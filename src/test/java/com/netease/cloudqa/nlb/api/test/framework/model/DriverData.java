/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

/**
 * 
 * @author hzzhangyan
 * @version $Id: DriverDate.java, v 0.1 2017-6-22 下午3:53:46 hzzhangyan Exp $
 */
public class DriverData {

    private List<DataUnit> driverData;

    public DriverData() {
    }

    /**
     * Getter method for property <tt>driverData</tt>.
     * 
     * @return property value of driverData
     */
    public List<DataUnit> getDriverData() {
        return driverData;
    }

    /**
     * Setter method for property <tt>driverData</tt>.
     * 
     * @param driverData value to be assigned to property driverData
     */
    public void setDriverData(List<DataUnit> driverData) {
        this.driverData = driverData;
    }

    public Object[] getDriverParam() {
        List<Object> objs = new ArrayList<Object>(0);
        if (CollectionUtils.isEmpty(driverData)) {
            return new Object[] {};
        }

        for (DataUnit unit : driverData) {
            objs.add(unit.getValue());
        }
        return objs.toArray();
    }

    @Override
    public String toString() {
        String driverDataStr = null == driverData ? "{}" : driverData.toString();
        return "DriverData [driverData = " + driverDataStr + "]";
    }

}
