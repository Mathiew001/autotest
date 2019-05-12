/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.model;

import java.util.ArrayList;
import java.util.List;

import com.netease.cloudqa.nlb.api.test.framework.common.runtime.ParallelRuntimeContext;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;

import com.netease.cloudqa.nlb.api.test.framework.common.runtime.ApiRuntimeContext;
import com.netease.cloudqa.nlb.api.test.framework.constant.FlagConstant;

/**
 * 数据库每一行的元素
 * @author hzzhangyan
 * @version $Id: ColumnData.java, v 0.1 2017-7-7 下午3:03:22 hzzhangyan Exp $
 */
public class ColumnData {

    protected static Logger logger      = Logger.getLogger(ColumnData.class);

    private List<DataUnit>  lines;

    private List<DataUnit>  selectKeys  = null;

    private List<DataUnit>  primaryKeys = null;

    private Object[]        importLines = null;

    private boolean         isDeleted   = false;

    private String          colName     = null;

    public ColumnData() {

    }

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    /**
     * 
     */
    public void initPk() {
        if (!CollectionUtils.isEmpty(primaryKeys)) {
            return;
        }

        primaryKeys = new ArrayList<DataUnit>();
        for (DataUnit unit : lines) {
            if (StringUtils.equalsIgnoreCase(unit.getFlag(), FlagConstant.P)) {
                primaryKeys.add(new DataUnit(unit.getName(), unit.getValue()));
            }
        }
    }

    /**
     * 
     */
    public void initSelKey() {

        selectKeys = new ArrayList<DataUnit>();
        for (DataUnit unit : lines) {
            if (StringUtils.equalsIgnoreCase(unit.getFlag(), FlagConstant.C)) {
                selectKeys.add(new DataUnit(unit.getName(), unit.getValue(), FlagConstant.C));
            }
            if (StringUtils.equalsIgnoreCase(unit.getFlag(), FlagConstant.C_AND_PARAM)) {
                selectKeys.add(new DataUnit(unit.getName(), ParallelRuntimeContext.CaseContext
                    .getPrameter((String) unit.getValue()), FlagConstant.C_AND_PARAM));
            }
        }
    }

    /**
     * Getter method for property <tt>isDeleted</tt>.
     * 
     * @return property value of isDeleted
     */
    public boolean isDeleted() {
        return isDeleted;
    }

    /**
     * Setter method for property <tt>isDeleted</tt>.
     * 
     * @param isDeleted value to be assigned to property isDeleted
     */
    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * @param lines
     */
    public ColumnData(List<DataUnit> lines, String colName) {
        super();
        this.lines = lines;
        this.colName = colName;
    }

    public ColumnData(List<DataUnit> lines) {
        super();
        this.lines = lines;
    }

    /**
     * Getter method for property <tt>lines</tt>.
     * 
     * @return property value of lines
     */
    public List<DataUnit> getLines() {
        return lines;
    }

    /**
     * Setter method for property <tt>lines</tt>.
     * 
     * @param lines value to be assigned to property lines
     */
    public void setLines(List<DataUnit> lines) {
        this.lines = lines;
    }

    /**
     * Getter method for property <tt>importLines</tt>.
     * 
     * @return property value of importLines
     */
    public Object[] getImportLines() {
        return importLines;
    }

    /**
     * Setter method for property <tt>importLines</tt>.
     * 
     * @param importLines value to be assigned to property importLines
     */
    public void setImportLines(Object[] importLines) {
        this.importLines = importLines;
    }

    /**
     * Getter method for property <tt>selectKeys</tt>.
     * 
     * @return property value of selectKeys
     */
    public List<DataUnit> getSelectKeys() {
        return selectKeys;
    }

    /**
     * Setter method for property <tt>selectKeys</tt>.
     * 
     * @param selectKeys value to be assigned to property selectKeys
     */
    public void setSelectKeys(List<DataUnit> selectKeys) {
        this.selectKeys = selectKeys;
    }

    /**
     * Getter method for property <tt>primaryKeys</tt>.
     * 
     * @return property value of primaryKeys
     */
    public List<DataUnit> getPrimaryKeys() {
        return primaryKeys;
    }

    /**
     * Setter method for property <tt>primaryKeys</tt>.
     * 
     * @param primaryKeys value to be assigned to property primaryKeys
     */
    public void setPrimaryKeys(List<DataUnit> primaryKeys) {
        this.primaryKeys = primaryKeys;
    }

    /**
     * 
     * 
     * @return
     */
    public String composeSelectSql(String tableName) {
        initSelKey();
        StringBuffer clos = new StringBuffer("");
        StringBuffer condition = new StringBuffer("");
        for (DataUnit unit : lines) {
            clos.append(",").append(unit.getName());
            if (StringUtils.equals(unit.getFlag(), FlagConstant.C)
                || StringUtils.equals(unit.getFlag(), FlagConstant.C_AND_PARAM)) {
                condition.append(" and ").append("( ").append(unit.getName()).append(" = ? )");
            }
        }
        clos.replace(0, 1, "");
        condition.replace(0, 4, "");

        String sql = "SELECT " + clos + " FROM " + tableName + " where " + condition;
        logger.info("excute sql : [" + sql + "]");
        return sql;
    }

    private int flagSize(String flag, boolean isEqual) {
        int len = 0;
        for (DataUnit unit : lines) {
            if (isEqual && StringUtils.equals(unit.getFlag(), flag)) {
                len++;
            }
            if (!isEqual && !StringUtils.equals(unit.getFlag(), flag)) {
                len++;
            }
        }
        return len;
    }

    /**
     * 
     */
    public void dbCompareCheck() {
        boolean hasSelectKey = false;
        if (CollectionUtils.isEmpty(lines)) {
            throw new RuntimeException("ColumnData paramCheck exception");
        }
        for (DataUnit unit : lines) {
            unit.dbCheck();
            if (StringUtils.equals(unit.getFlag(), FlagConstant.C)
                || StringUtils.equals(unit.getFlag(), FlagConstant.C_AND_PARAM)) {
                hasSelectKey = true;
            }
        }
        if (!hasSelectKey) {
            throw new RuntimeException("dbCompare data has no selectKey");
        }
    }

    /**
     * 
     */
    public void dbImportCheck() {
        boolean hasPK = false;
        if (CollectionUtils.isEmpty(lines)) {
            throw new RuntimeException("ColumnData paramCheck exception");
        }
        for (DataUnit unit : lines) {
            unit.dbCheck();
            if (StringUtils.equals(unit.getFlag(), FlagConstant.P)) {
                hasPK = true;
            }
        }
        if (!hasPK) {
            throw new RuntimeException("Import tables has no pk");
        }
    }

    /**
     * 
     * @param tableName
     * @return
     */
    public String composeImportSql(String tableName) {
        int j = 0;
        StringBuffer lineBuffer = new StringBuffer();
        StringBuffer valueBuffer = new StringBuffer();
        importLines = new Object[flagSize(FlagConstant.N, false) - flagSize(FlagConstant.F, true)];

        for (DataUnit unit : this.getLines()) {
            if (!FlagConstant.checkFlag(unit.getFlag())) {
                throw new RuntimeException("db import col flag err");
            }
            // fun
            if (StringUtils.equalsIgnoreCase(unit.getFlag(), FlagConstant.F)) {
                lineBuffer.append(unit.getName()).append(",");
                valueBuffer.append(unit.getValue()).append(",");
            } else if (!StringUtils.equalsIgnoreCase(unit.getFlag(), FlagConstant.N)) {
                lineBuffer.append(unit.getName()).append(",");
                valueBuffer.append("?").append(",");
                importLines[j] = unit.getValue();
                j++;
            }
        }

        String tableAndCol = "insert into " + tableName + " ("
                             + lineBuffer.substring(0, lineBuffer.length() - 1) + ") ";

        String values = " (" + valueBuffer.substring(0, valueBuffer.length() - 1) + ") ";
        String sql = tableAndCol + "values" + values;
        logger.info("excute sql : [" + sql + "]");
        logger.info("excute sql : [" + primaryKeys + "]" + "excute sql : [" + importLines + "]");
        return sql;
    }

    /**
     * 
     * @param tableName
     * @return
     */
    public String composeDelSql(String tableName, String... flags) {
        StringBuffer whereBuffer = new StringBuffer();
        for (DataUnit unit : this.getLines()) {
            boolean hasKey = false;
            for (String flag : flags) {
                if (StringUtils.equals(unit.getFlag(), flag)) {
                    hasKey = true;
                }
            }
            if (hasKey) {
                whereBuffer.append(" and ").append(unit.getName()).append(" = ?");
            }
        }
        String sql = "delete from " + tableName + " where " + whereBuffer.replace(0, 4, "");
        logger.info("excute sql : [" + sql + "]");
        return sql;
    }

    /** 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String str = lines == null ? "ColumnData[null]" : "ColumnData[" + lines.toString() + "]";
        return str;
    }

}
