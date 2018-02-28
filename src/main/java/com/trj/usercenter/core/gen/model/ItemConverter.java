package com.trj.usercenter.core.gen.model;


import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class ItemConverter implements Converter {

    @Override
    public void marshal(Object o, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        Item item = (Item)o;
        hierarchicalStreamWriter.addAttribute("name",item.getName());
        hierarchicalStreamWriter.addAttribute("type",item.getType());
        hierarchicalStreamWriter.addAttribute("javaType",item.getJavaType());
        hierarchicalStreamWriter.addAttribute("notNull",item.getNotNull());
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        Item item = new Item();
        item.setName(hierarchicalStreamReader.getAttribute("name"));
        item.setJavaType(hierarchicalStreamReader.getAttribute("javaType"));
        item.setNotNull(hierarchicalStreamReader.getAttribute("notNull"));
        item.setType(hierarchicalStreamReader.getAttribute("type"));
        return item;
    }

    @Override
    public boolean canConvert(Class aClass) {
        return aClass.equals(Item.class);
    }
}
