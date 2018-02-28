package com.trj.usercenter.core.gen.model;


import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

@XStreamAlias("root")
public class TableRoot {

    @XStreamImplicit(itemFieldName = "table")
    private List<Table> tableList;

    public List<Table> getTableList() {
        return tableList;
    }

    public void setTableList(List<Table> tableList) {
        this.tableList = tableList;
    }
}
