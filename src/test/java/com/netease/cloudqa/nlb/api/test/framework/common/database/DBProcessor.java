/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.common.database;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;

import com.netease.cloudqa.nlb.api.test.framework.common.runtime.ApiRuntimeContext;
import com.netease.cloudqa.nlb.api.test.framework.constant.FlagConstant;
import com.netease.cloudqa.nlb.api.test.framework.constant.ParamConstant;
import com.netease.cloudqa.nlb.api.test.framework.model.ColumnData;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.framework.model.TableData;
import com.netease.cloudqa.nlb.api.test.framework.utils.DBUtils;
import com.netease.cloudqa.nlb.api.test.framework.utils.DataUnitUtils;
import com.netease.cloudqa.nlb.api.test.framework.utils.PatternUtils;

/**
 * 数据库处理器,维护与TableData模型相关的一系列操作：
 * 1. 数据库数据比对
 * 2. 准备数据导入
 * 
 * @author hzzhangyan
 * @version $Id: DBProcessor.java, v 0.1 2017-6-22 下午7:32:08 hzzhangyan Exp $
 */
public class DBProcessor {

    protected static Logger logger = Logger.getLogger(DBProcessor.class);

    /**
     * 批量行比对
     * @param caseId
     * @param runtimeContext
     * @return
     */
    public static List<String> compareTable(List<TableData> tables) {
        List<String> checkInfos = new ArrayList<String>();
        if (!CollectionUtils.isEmpty(tables)) {
            for (TableData table : tables) {
                // check 
                table.dbCompareCheck();
                // compare
                checkInfos.addAll(compareTable(table));
            }
        } else {
            logger.warn("dataList is empty , dbcheck execution ignored");
        }

        return checkInfos;
    }

    /**
     * 单表比对
     * @param tableDta
     * @return
     */
    public static List<String> compareTable(TableData table) {
        List<String> checkInfo = new ArrayList<String>();
        checkInfo.addAll(compareCol(table.getTableName(), table.getColumns()));
        return checkInfo;
    }

    /**
     * 批量行比对
     * @param tableDta
     * @return
     */
    private static List<String> compareCol(String tableName, List<ColumnData> clos) {
        List<String> checkInfo = new ArrayList<String>();
        for (ColumnData col : clos) {
            checkInfo.addAll(compareCol(tableName, col));
        }
        return checkInfo;
    }

    /**
     * 
     * 表的比对
     * @param tableName
     * @param clo
     * @return
     */
    private static List<String> compareCol(String tableName, ColumnData clo) {
        List<String> checkInfos = new ArrayList<String>();
        // 组装sql
        String sql = clo.composeSelectSql(tableName);

        // 获得actual
        List<Map<String, Object>> dbResult = DBUtils.getJdbcTemplate(tableName).queryForList(sql,
            DataUnitUtils.filterObject(clo.getSelectKeys()));

        // 期望数据被删除
        if (clo.isDeleted() && CollectionUtils.isEmpty(dbResult)) {
            return checkInfos;
        }

        if (null == dbResult || dbResult.size() != 1) {
            throw new RuntimeException("Failed checking table [" + tableName + "], column ["
                                       + clo.toString()
                                       + "], select return too many results or nothing");
        }

        Map<String, Object> actual = dbResult.get(0);
        for (DataUnit exptectUnit : clo.getLines()) {
            String attName = exptectUnit.getName();
            for (Map.Entry<String, Object> actUnit : actual.entrySet()) {
                if (StringUtils.equalsIgnoreCase(attName, actUnit.getKey())) {
                    String checkInfo = simpleCompare(tableName, attName, exptectUnit.getFlag(),
                        exptectUnit.getValue(), actUnit.getValue());
                    if (!StringUtils.isEmpty(checkInfo)) {
                        checkInfos.add(checkInfo + "\n");
                    }
                    break;
                }
            }
        }

        return checkInfos;
    }

    //    private static List<String> LineCompare(TableData expect, TableData actual) {
    //        List<String> logsInfo = new ArrayList<String>();
    //        if (expect == null ^ actual == null) {
    //            logsInfo.add("Failed checking db param, expect:[" + expect + "] while actual:["
    //                         + actual + "]");
    //        }
    //
    //        if (null != expect && CollectionUtils.isEmpty(expect.getFlags())) {
    //            for (Map.Entry<String, String> flag : expect.getFlags().entrySet()) {
    //                if (!FlagConstant.flagIllegal(flag.getValue())) {
    //                    logsInfo.add("Failed checking db param, expect table flagIllegal:["
    //                                 + expect.getTableName() + "] ");
    //                    continue;
    //                }
    //
    //                String compareContent = compareFiled(flag.getValue(),
    //                    expect.getArgByName(flag.getKey()), actual.getArgByName(flag.getKey()));
    //                if (StringUtils.isNotEmpty(compareContent)) {
    //                    logsInfo.add(compareContent);
    //                }
    //            }
    //        }
    //
    //        return logsInfo;
    //    }

    /**
     * 
     * 
     * @param flag
     * @param expect
     * @param actual
     * @return
     */
    public static String simpleCompare(String tableName, String colName, String flag,
                                       Object expect, Object actual) {
        String colInfo = "tableName[" + tableName + "],colName[" + colName + "]";
        if (!FlagConstant.checkFlag(flag)) {
            return colInfo + " dbcheck fail, flagIllegal :[" + flag + "]";
        }

        if (StringUtils.equals(FlagConstant.N, flag)) {
            return null;
        }

        if (null == expect ^ null == actual) {
            return colInfo + " dbcheck fail, expect value:[" + expect + "] while actual:[" + actual
                   + "]";
        }

        try {

            if (StringUtils.equals(FlagConstant.PARAM, flag)
                && StringUtils.contains(expect.toString(), ParamConstant.DOLLAR_MARK)) {
                // get and compare
                if (PatternUtils.matcher(expect.toString(), ParamConstant.GET_PARAM_REG)) {
                    String key = PatternUtils.extractByReg(expect.toString(),
                        ParamConstant.GET_PARAM_REG);
                    Object ctxParam = ApiRuntimeContext.CaseContext.getPrameter(key);
                    if (null == ctxParam) {
                        return colInfo + " dbcheck fail, use key :[" + key
                               + "] find null objet in contxt ";
                    }
                    String expVal = StringUtils
                        .replace(expect.toString(), key, ctxParam.toString());
                    if (StringUtils.equals(expVal, actual.toString())) {
                        return null;
                    } else {
                        return colInfo + " dbcheck fail, expect value:[" + expVal
                               + "] while actual:[" + actual + "]";
                    }
                }

                if (PatternUtils.matcher(expect.toString(), ParamConstant.SET_PARAM_REG)) {
                    String setKey = PatternUtils.extractByReg(expect.toString(),
                        ParamConstant.SET_PARAM_REG);
                    ApiRuntimeContext.CaseContext.addPrameter(new DataUnit(StringUtils.replace(
                        setKey, "=", ""), actual.toString()));
                    return null;
                }

                return colInfo + " dbcheck fail, '$' not found in expect value";
            }

            if (StringUtils.equals(FlagConstant.Y, flag)) {
                if (StringUtils.equals((String) expect, (String) actual)) {
                    return null;
                } else {
                    return colInfo + " dbcheck fail , expect value:[" + expect + "] while actual:["
                           + actual + "]";
                }
            }

            if (StringUtils.equals(FlagConstant.C, flag)) {
                if (StringUtils.equals(expect.toString(), actual.toString())) {
                    return null;
                }
                else if (((Boolean) expect).booleanValue() == ((Boolean) actual).booleanValue()) {
                    return null;
                }
                else {
                    return colInfo + " dbcheck fail , expect value:[" + expect + "] while actual:["
                           + actual + "]";
                }
            }

            if (StringUtils.equals(FlagConstant.C_AND_PARAM, flag)) {
                String replacedVal = (String) ApiRuntimeContext.CaseContext
                    .getPrameter((String) expect);

                if (StringUtils.equals(replacedVal, (String) actual)) {
                    return null;
                } else {
                    return colInfo + " dbcheck fail , expect value:[" + expect + "] while actual:["
                           + actual + "]";
                }
            }

            if (StringUtils.equals(FlagConstant.R, flag)) {
                if (!PatternUtils.matcher((String) actual, (String) expect)) {
                    return colInfo + " dbcheck fail ,  actual value:[" + actual
                           + "] not match regex :[" + expect + "] ";
                } else {
                    return null;
                }
            }

            if (StringUtils.contains(flag, FlagConstant.D)) {
                long timeFlow = Long.valueOf(flag.replace("D", ""));
                Date realDate = null;
                Date expDate = null;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                if (actual instanceof Date) {
                    realDate = (Date) actual;
                } else {
                    realDate = sdf.parse((String) actual);

                }
                if (expect instanceof Date) {
                    expDate = (Date) expect;
                } else if (((String) expect).equalsIgnoreCase(FlagConstant.NOW)) {
                    expDate = new Date();
                } else {
                    expDate = sdf.parse((String) expect);
                }

                if (Math.abs((realDate.getTime() - expDate.getTime())) > timeFlow) {
                    return colInfo + " dbcheck fail ,  actual value:[" + realDate + "] expValue :["
                           + expDate + "] ";
                } else {
                    return null;
                }
            }

            if (StringUtils.equals(FlagConstant.INT, flag)) {
                if (((Integer) expect).intValue() == ((Integer) actual).intValue()) {
                    return null;
                } else {
                    return colInfo + " dbcheck fail , expect value:[" + expect + "] while actual:["
                           + actual + "]";
                }
            }

            if (StringUtils.equals(FlagConstant.BOOLEAN, flag)) {
                if (((Boolean) expect).booleanValue() == ((Boolean) actual).booleanValue()) {
                    return null;
                } else {
                    System.out.println("expect: " + ((Boolean) expect).booleanValue());
                    System.out.println("actual: " + ((Boolean) expect).booleanValue());
                    return colInfo + " dbcheck fail , expect value:[" + expect + "] while actual:["
                            + actual + "]";
                }
            }

            if (StringUtils.equals(FlagConstant.SPLIT_CONTAIN, flag)) {
                for (String ct : StringUtils.split((String) expect, "||")) {
                    if (!StringUtils.contains((String) actual, ct)) {
                        return colInfo + " dbcheck fail , expect value:[" + expect
                               + "] not contain info:[" + ct + "]";
                    }
                }
                return null;
            }

            // NOTE:snake-yaml会将long会强转成int的bug兼容
            if (StringUtils.equals(FlagConstant.LONG, flag)) {
                if (StringUtils.equals(String.valueOf(expect.toString()),
                    String.valueOf(actual.toString()))) {
                    return null;
                } else {
                    return colInfo + " dbcheck fail , expect value:[" + expect + "] while actual:["
                           + actual + "]";
                }
            }

            // NOTE:snake-yaml会将long会强转成int的bug兼容
            if (StringUtils.equals(FlagConstant.BIGINT, flag)) {
                if (StringUtils.equals(String.valueOf(expect.toString()),
                    String.valueOf(actual.toString()))) {
                    return null;
                } else {
                    return colInfo + " dbcheck fail , expect value:[" + expect + "] while actual:["
                           + actual + "]";
                }
            }

            return colInfo + " dbcheck fail , do no check, expect :[" + expect + "] while actual:["
                   + actual + "]";

        } catch (Exception e) {
            e.printStackTrace();
            return colInfo + " dbcheck fail , happen Exception: expect :[" + expect
                   + "] while actual:[" + actual + "]";
        }
    }

    /**
     * 
     * @param tables
     */
    public static void dbImport(List<TableData> tables) {
        if (!CollectionUtils.isEmpty(tables)) {
            for (TableData table : tables) {
                // check 
                table.dbImportCheck();
                // compare
                doImport(table);
            }
        } else {
            logger.warn("dataList is empty , dbcheck execution ignored");
        }
    }

    /**
     * 
     * @param table
     */
    public static void doImport(TableData table) {
        for (ColumnData col : table.getColumns()) {
            importCol(table.getTableName(), col);
        }
    }

    /**
     * 
     * @param tableName
     * @param col
     */
    private static void importCol(String tableName, ColumnData col) {
        String sql = col.composeImportSql(tableName);
        DBUtils.getJdbcTemplate(tableName).update(sql, col.getImportLines());
    }

    /**
     * 
     * @param tables
     */
    public static void dbClean(List<TableData> tables) {
        if (!CollectionUtils.isEmpty(tables)) {
            for (TableData table : tables) {
                dbClean(table);
            }
        } else {
            logger.warn("tables is empty , dbClean execution ignored");
        }
    }

    /**
     * 
     * @param table
     */
    private static void dbClean(TableData table) {
        for (ColumnData col : table.getColumns()) {
            dbClean(table.getTableName(), col);
        }
    }

    /**
     * 
     * @param tableName
     * @param col
     */
    private static void dbClean(String tableName, ColumnData col) {
        col.initPk();
        if (!CollectionUtils.isEmpty(col.getPrimaryKeys())) {
            String sql = col.composeDelSql(tableName, FlagConstant.P);
            Object[] objects = DataUnitUtils.filterObject(col.getPrimaryKeys());
            DBUtils.getJdbcTemplate(tableName).update(sql, objects);
            return;
        }
        col.initSelKey();
        if (!CollectionUtils.isEmpty(col.getSelectKeys())) {
            String sql = col.composeDelSql(tableName, FlagConstant.C, FlagConstant.C_AND_PARAM);
            Object[] objects = DataUnitUtils.filterObject(col.getSelectKeys());
            DBUtils.getJdbcTemplate(tableName).update(sql, objects);
            return;
        }
    }

}
