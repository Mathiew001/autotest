/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.common.runtime.impl;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.framework.model.DriverData;
import com.netease.cloudqa.nlb.api.test.framework.model.TableData;

/**
 * 
 * @author hzzhangyan
 * @version $Id: DataHolderImpl.java, v 0.1 2017-6-22 下午4:05:02 hzzhangyan Exp $
 */
public class DataHolderImpl implements DataHolder {

    //    private final static String REST_API_RET_KEY = "rest_api_ret_key";

    private DriverData      driverData;

    private List<TableData> dbPrepareData;

    private List<TableData> dbExpectData;

    private List<DataUnit>  etcdPrepareData;

    private List<DataUnit>  etcdExpectData;

    private String caseLabel;

    // YAMAL文件不兼容json文件,使用字符串兼容
    private String          expRespData;

    // YAMAL文件不兼容json文件,使用字符串兼容
    private String          actRespData;

    //    private JSONObject          expectJsonData;
    //
    //    private JSONObject          actualJsonData;

    public DataHolderImpl() {
    }

    @Override
    public String getCaseLabel() {
        return caseLabel;
    }

    @Override
    public void setCaseLabel(String caseLabel) {
        this.caseLabel = caseLabel;
    }


    @Override
    public List<DataUnit> getEtcdPrepareData() {
        return etcdPrepareData;
    }

    @Override
    public void setEtcdPrepareData(List<DataUnit> etcdPrepareData) {
        this.etcdPrepareData = etcdPrepareData;
    }

    @Override
    public List<DataUnit> getEtcdExpectData() {
        return etcdExpectData;
    }

    @Override
    public void setEtcdExpectData(List<DataUnit> etcdExpectData) {
        this.etcdExpectData = etcdExpectData;
    }

    /**
     * Getter method for property <tt>driverData</tt>.
     * 
     * @return property value of driverData
     */
    @Override
    public DriverData getDriverData() {
        return driverData;
    }

    /**
     * Setter method for property <tt>driverData</tt>.
     * 
     * @param driverData value to be assigned to property driverData
     */
    @Override
    public void setDriverData(DriverData driverData) {
        this.driverData = driverData;
    }

    /**
     * Setter method for property <tt>inputArgs</tt>.
     * 
     * @param inputArgs value to be assigned to property inputArgs
     */
    @Override
    public void setDriverData(List<DataUnit> units) {
        if (driverData == null) {
            driverData = new DriverData();
        }
        driverData.setDriverData(units);
    }

    /**
     * Getter method for property <tt>dbPrepareData</tt>.
     * 
     * @return property value of dbPrepareData
     */
    @Override
    public List<TableData> getDbPrepareData() {
        return dbPrepareData;
    }

    /**
     * Setter method for property <tt>dbPrepareData</tt>.
     * 
     * @param dbPrepareData value to be assigned to property dbPrepareData
     */
    @Override
    public void setDbPrepareData(List<TableData> dbPrepareData) {
        this.dbPrepareData = dbPrepareData;
    }

    /**
     * Getter method for property <tt>dbExpectData</tt>.
     * 
     * @return property value of dbExpectData
     */
    @Override
    public List<TableData> getDbExpectData() {
        return dbExpectData;
    }

    /**
     * Setter method for property <tt>dbExpectData</tt>.
     * 
     * @param dbExpectData value to be assigned to property dbExpectData
     */
    @Override
    public void addDbExpectData(String tableName, String colName, DataUnit dataUnit) {
        if (this.dbExpectData == null)
            return;
        if (colName.equals("all")) {
            for (int i = 0; i < this.dbExpectData.size(); i++) {
                TableData tableData = this.dbExpectData.get(i);
                if (tableData.getTableName().equals(tableName)) {
                    if (colName == null) {
                        tableData.getColumns().get(0).getLines().add(dataUnit);
                        break;
                    }
                    else {
                        for (int j = 0; j < tableData.getColumns().size(); j++)
                            tableData.getColumns().get(j).getLines().add(dataUnit);
                    }
                }
            }
        }
        for (int i = 0; i < this.dbExpectData.size(); i++) {
            TableData tableData = this.dbExpectData.get(i);
            if (tableData.getTableName().equals(tableName)) {
                if (colName == null) {
                    tableData.getColumns().get(0).getLines().add(dataUnit);
                    break;
                }
                else {
                    for (int j = 0; j < tableData.getColumns().size(); j++) {
                        if (tableData.getColumns().get(j).getColName().equals(colName)) {
                            tableData.getColumns().get(j).getLines().add(dataUnit);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void addDbExpectData(String tableName, DataUnit dataUnit) {
        if (this.dbExpectData == null)
            return;
        for (int i = 0; i < this.dbExpectData.size(); i++) {
            TableData tableData = this.dbExpectData.get(i);
            if (tableData.getTableName().equals(tableName)) {
                tableData.getColumns().get(0).getLines().add(dataUnit);
                break;
            }
        }
    }

    /**
     * Setter method for property <tt>dbExpectData</tt>.
     *
     * @param dbExpectData value to be assigned to property dbExpectData
     */
    @Override
    public void setDbExpectData(List<TableData> dbExpectData) {
        this.dbExpectData = dbExpectData;
    }

    /** 
     * @see com.netease.push.server.sdk.framework.common.runtime.DataHolder#getDriverUnits()
     */
    @Override
    public List<DataUnit> getDriverUnits() {
        if (null != driverData) {
            return driverData.getDriverData();
        }
        return null;
    }

    //    /** 
    //     * @see com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder#getApiExpData()
    //     */
    //    @Override
    //    public JSON getApiExpData() {
    //        if (expectJsonData == null || expectJsonData.get(REST_API_RET_KEY) == null) {
    //            return null;
    //        }
    //        return (JSON) expectJsonData.get(REST_API_RET_KEY);
    //    }
    //
    //    /**
    //     * 
    //     * @see com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder#setApiExpData(com.alibaba.fastjson.JSON)
    //     */
    //    @Override
    //    public void setApiExpData(JSON js) {
    //        if (expectJsonData == null) {
    //            expectJsonData = new JSONObject();
    //        }
    //        expectJsonData.put(REST_API_RET_KEY, js);
    //    }
    //
    //    /**
    //     * 
    //     * @see com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder#getRestApiActData()
    //     */
    //    @Override
    //    public JSON getApiActData() {
    //        if (actualJsonData == null || actualJsonData.get(REST_API_RET_KEY) == null) {
    //            return null;
    //        }
    //        return (JSON) actualJsonData.get(REST_API_RET_KEY);
    //    }
    //
    //    /**
    //     * 
    //     * @see com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder#setRestApiActData(com.alibaba.fastjson.JSON)
    //     */
    //    @Override
    //    public void setRestApiActData(JSON js) {
    //        if (actualJsonData == null) {
    //            actualJsonData = new JSONObject();
    //        }
    //        actualJsonData.put(REST_API_RET_KEY, js);
    //    }

    /** 
     * @see com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder#getApiExpRespData()
     */
    @Override
    public JSON getApiExpRespData() {
        return JSON.parseObject(expRespData);
    }

    /** 
     * @see com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder#setApiExpRespData(com.alibaba.fastjson.JSON)
     */
    @Override
    public void setApiExpRespData(Object jsObj) {
        if (jsObj instanceof JSON) {
            expRespData = ((JSON) jsObj).toJSONString();
        } else if (jsObj instanceof String) {
            expRespData = (String) jsObj;
        } else {
            throw new RuntimeException("类型不支持");
        }
    }

    /** 
     * @see com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder#getApiActRespData()
     */
    @Override
    public JSON getApiActRespData() {
        return JSON.parseObject(actRespData);
    }

    /** 
     * @see com.netease.cloudqa.nlb.api.test.framework.common.runtime.DataHolder#setApiActRespData(com.alibaba.fastjson.JSON)
     */
    @Override
    public void setApiActRespData(Object jsObj) {
        if (jsObj instanceof JSON) {
            actRespData = ((JSON) jsObj).toJSONString();
        } else if (jsObj instanceof String) {
            actRespData = (String) jsObj;
        } else {
            throw new RuntimeException("类型不支持");
        }
    }

    @Override
    public String toString() {
        String inputArgsStr = null == driverData ? "{}" : driverData.toString();
        String dataBasePrepareStr = null == dbPrepareData ? "{}" : dbPrepareData.toString();
        String dataBaseExpectStr = null == dbExpectData ? "{}" : dbExpectData.toString();
        return "DataHolder [driverData = " + inputArgsStr + ", dbPrepareData=" + dataBasePrepareStr
               + ", dbExpectData=" + dataBaseExpectStr + "]";
    }

}
