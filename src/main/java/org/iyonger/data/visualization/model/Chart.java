package org.iyonger.data.visualization.model;

import java.util.List;

/**
 * Created by yongfu on 10/13/2016.
 */
public class Chart {
    String name;
    List<String> columns;
    List<String> values;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
}
