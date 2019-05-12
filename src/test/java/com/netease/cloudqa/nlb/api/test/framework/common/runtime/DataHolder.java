/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.common.runtime;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.netease.cloudqa.nlb.api.test.framework.model.DataUnit;
import com.netease.cloudqa.nlb.api.test.framework.model.DriverData;
import com.netease.cloudqa.nlb.api.test.framework.model.TableData;

/**
 * 
 * @author hzzhangyan
 * @version $Id: DataHolder.java, v 0.1 2017-6-22 下午4:02:50 hzzhangyan Exp $
 */
public interface DataHolder {

    DriverData getDriverData();

    void setDriverData(DriverData driverData);

    List<TableData> getDbPrepareData();

    void setDbPrepareData(List<TableData> dbPrepareData);

    List<TableData> getDbExpectData();

    void setDbExpectData(List<TableData> dbExpectData);

    void addDbExpectData(String tableName, DataUnit dataUnit);

    void addDbExpectData(String tableName, String colName, DataUnit dataUnit);

    void setDriverData(List<DataUnit> units);

    List<DataUnit> getDriverUnits();

    public List<DataUnit> getEtcdPrepareData();

    public void setEtcdPrepareData(List<DataUnit> etcdPrepareData);

    public List<DataUnit> getEtcdExpectData();

    public void setEtcdExpectData(List<DataUnit> etcdExpectData);

    JSON getApiExpRespData();

    void setApiExpRespData(Object jsObj);

    JSON getApiActRespData();

    void setApiActRespData(Object jsObj);

    void setCaseLabel(String caseLabel);

    String getCaseLabel();
}
