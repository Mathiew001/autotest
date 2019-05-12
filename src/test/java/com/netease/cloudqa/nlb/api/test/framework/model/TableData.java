/**
 * http://www.163.com
 * Copyright (c) 1997-2017 All Rights Reserved.
 */
package com.netease.cloudqa.nlb.api.test.framework.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;

/**
 * 
 * @author hzzhangyan
 * @version $Id: TableData.java, v 0.1 2017-6-22 下午3:55:48 hzzhangyan Exp $
 */
public class TableData {
    protected static Logger  logger = Logger.getLogger(TableData.class);

    private String           tableName;

    private String           tableClass;

    private List<ColumnData> columns;

    public TableData() {
    }

    /**
     * 
     */
    public void dbCompareCheck() {
        if (StringUtils.isEmpty(tableName) || CollectionUtils.isEmpty(columns)) {
            throw new RuntimeException("invalid attribute :" + this.toString());
        }
        for (ColumnData col : columns) {
            col.dbCompareCheck();
        }
    }

    public void addColumn(List<DataUnit> units, String colName) {
        if (null == columns) {
            columns = new ArrayList<ColumnData>();
        }
        columns.add(new ColumnData(units, colName));
    }


    public void addColumn(List<DataUnit> units) {
        if (null == columns) {
            columns = new ArrayList<ColumnData>();
        }
        columns.add(new ColumnData(units));
    }

    /**
     * 
     */
    public void dbImportCheck() {
        if (StringUtils.isEmpty(tableName) || CollectionUtils.isEmpty(columns)) {
            throw new RuntimeException("invalid attribute :" + this.toString());
        }
        for (ColumnData col : columns) {
            col.dbImportCheck();
        }
    }

    /**
     * Getter method for property <tt>tableName</tt>.
     * 
     * @return property value of tableName
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * Setter method for property <tt>tableName</tt>.
     * 
     * @param tableName value to be assigned to property tableName
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * Getter method for property <tt>tableClass</tt>.
     * 
     * @return property value of tableClass
     */
    public String getTableClass() {
        return tableClass;
    }

    /**
     * Setter method for property <tt>tableClass</tt>.
     * 
     * @param tableClass value to be assigned to property tableClass
     */
    public void setTableClass(String tableClass) {
        this.tableClass = tableClass;
    }

    /**
     * Getter method for property <tt>columns</tt>.
     * 
     * @return property value of columns
     */
    public List<ColumnData> getColumns() {
        return columns;
    }

    /**
     * Setter method for property <tt>columns</tt>.
     * 
     * @param columns value to be assigned to property columns
     */
    public void setColumns(List<ColumnData> columns) {
        this.columns = columns;
    }

    @Override
    public String toString() {
        String colValueStr = null == columns ? "{}" : columns.toString();
        return "TableData [tableName = " + tableName + ", tableClass=" + tableClass + ", colValue="
               + colValueStr + "]";
    }

}
