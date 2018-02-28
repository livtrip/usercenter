package com.trj.usercenter.core.gen.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * @author xierongli
 * @version $$Id: usercenter, v 0.1 18/2/28 下午3:11 mark1xie Exp $$
 */
@XStreamAlias("method")
public class Method {
    @XStreamAsAttribute
    private String name;
    @XStreamAsAttribute
    private String methodName;

    @XStreamImplicit(itemFieldName = "item")
    private List<Item> itemList;


    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
