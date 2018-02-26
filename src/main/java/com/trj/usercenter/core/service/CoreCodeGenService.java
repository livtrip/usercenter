package com.trj.usercenter.core.service;

import com.trj.usercenter.core.gen.model.Attribute;
import com.trj.usercenter.core.gen.model.Entity;
import org.beetl.sql.core.JavaType;
import org.beetl.sql.core.NameConversion;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.db.ClassDesc;
import org.beetl.sql.core.db.ColDesc;
import org.beetl.sql.core.db.MetadataManager;
import org.beetl.sql.core.db.TableDesc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author xierongli
 * @version $$Id: usercenter, v 0.1 18/2/24 下午5:53 mark1xie Exp $$
 */
@Service
public class CoreCodeGenService {

    @Autowired
    SQLManager sqlManager;

    public List<Entity> getAllEntityInfo(){
        MetadataManager meta = sqlManager.getMetaDataManager();
        Set<String> set = meta.allTable();
        List<Entity> list = new ArrayList<Entity>();
        for(String table:set) {
            list.add(getEntitySimpleInfo(table));
        }
        return list;
    }
    public Entity getEntitySimpleInfo(String table) {
        MetadataManager meta = sqlManager.getMetaDataManager();
        NameConversion nc = sqlManager.getNc();
        TableDesc tableDesc = meta.getTable(table);
        if(tableDesc==null) {
            return null;
        }
        ClassDesc classDesc = tableDesc .getClassDesc(nc);
        Entity e = new Entity();
        e.setName(nc.getClassName(table));
        e.setComment(tableDesc.getRemark());
        e.setTableName(table);
        return e;
    }

    public Entity getEntityInfo(String table) {
        MetadataManager meta = sqlManager.getMetaDataManager();
        NameConversion nc = sqlManager.getNc();
        TableDesc tableDesc = meta.getTable(table);
        if(tableDesc==null) {
            return null;
        }
        ClassDesc classDesc = tableDesc .getClassDesc(nc);
        Entity e = new Entity();
        e.setName(nc.getClassName(table));
        e.setComment(tableDesc.getRemark());
        e.setTableName(table);
        e.setCode(getEntityCode(e.getName()));

        Set<String> cols = tableDesc.getCols();
        ArrayList<Attribute> attrs = new ArrayList<Attribute>();
        int i=1;
        for(String col:cols) {
            ColDesc desc = tableDesc.getColDesc(col);
            Attribute attr = new Attribute();
            attr.setColName(col);
            attr.setName(nc.getPropertyName(col));
            if(tableDesc.getIdNames().contains(col)) {
                //TODO,代码生成实际上用了一个Id，因此具备联合主键的，不应该生成代码
                attr.setId(true);
                e.setIdAttribute(attr);
            }
            attr.setComment(desc.remark);
            String type = JavaType.getType(desc.sqlType, desc.size, desc.digit);
            if(type.equals("Double")){
                type = "BigDecimal";
            }
            if(type.equals("Timestamp")){
                type ="Date";
            }
            attr.setJavaType(type);
            setGetDisplayName(attr);
            attrs.add(attr);



        }
        e.setList(attrs);

        return e;
    }

    //根据类名提供一个变量名
    private String getEntityCode(String s) {
        //找到最后一个大写字母，以此为变量名
        if (Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder())
                    .append(Character.toLowerCase(s.charAt(0)))
                    .append(s.substring(1)).toString();

    }
    /*根据数据库注释来判断显示名称*/
    private void setGetDisplayName(Attribute attr) {
        String comment = attr.getComment();
        if(comment==null) {
            attr.setDisplayName(attr.getName());
            return ;
        }
        String displayName = null;
        int index = comment.indexOf(",");
        if(index!=-1) {
            displayName =  comment.substring(0,index);
            attr.setDisplayName(displayName);
        }else {
            attr.setDisplayName(attr.getName());
        }
    }
}
