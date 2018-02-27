package com.trj.usercenter.core.web;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.trj.usercenter.core.gen.JavaCodeGen;
import com.trj.usercenter.core.gen.MavenProjectTarget;
import com.trj.usercenter.core.gen.model.Attribute;
import com.trj.usercenter.core.gen.model.Entity;
import com.trj.usercenter.core.service.CoreCodeGenService;
import com.trj.usercenter.tool.Result;
import com.trj.usercenter.tool.Results;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CoreCodeGenController {
    private final Log log = LogFactory.getLog(this.getClass());
    private static final String MODEL = "/core/codeGen";

    @Autowired
    CoreCodeGenService codeGenService;


    @GetMapping(MODEL + "/tableDetail.do")
    public ModelAndView tableDetail(String table) {
        ModelAndView view = new ModelAndView("/core/codeGen/edit.html");
        Entity entity = codeGenService.getEntityInfo(table);
        view.addObject("entity", entity);
        return view;

    }

    @PostMapping(MODEL + "/table.json")
    @ResponseBody
    public Result<List<Entity>> getTable() {
        List<Entity> list = codeGenService.getAllEntityInfo();
        return Results.newSuccessResult(list);
    }

    @PostMapping(MODEL + "/tableDetail.json")
    @ResponseBody
    public Result<Entity> getInfo(String table) {
        Entity entity = codeGenService.getEntityInfo(table);
        if (entity == null) {
            Results.newFailedResult("表不存在");
        }
        return Results.newSuccessResult(entity);

    }

    @PostMapping(MODEL + "/gen.json")
    @ResponseBody
    public Result<Boolean> gen(String table) {
        Entity entity = codeGenService.getEntityInfo(table);
        System.out.println(JSON.toJSONString(entity));
        String urlBase = "user";
        String basePackage = "com.trj.usercenter";

        MavenProjectTarget target = new MavenProjectTarget(entity, basePackage);
        target.setUrlBase(urlBase);
        JavaCodeGen javaGen = new JavaCodeGen(basePackage, entity);
        javaGen.make(target, entity);
        return Results.newSuccessResult(true);

    }


    private Entity getEntitiyInfo(EntityInfo data) {
        Entity info = data.getEntity();
        String urlBase = data.getUrlBase();
        String basePackage = data.getBasePackage();
        Entity entity = codeGenService.getEntityInfo(info.getTableName());
        entity.setCode(info.getCode());
        entity.setDisplayName(info.getDisplayName());
        entity.setSystem(info.getSystem());
        for (int i = 0; i < entity.getList().size(); i++) {
            Attribute attr = entity.getList().get(i);
            attr.setDisplayName(info.getList().get(i).getDisplayName());
            attr.setShowInQuery(info.getList().get(i).isShowInQuery());
            if(attr.getName().equals(data.getNameAttr())) {
                entity.setNameAttribute(attr);
            }

        }


        return entity;
    }

    @GetMapping(MODEL + "/{table}/test.json")
    @ResponseBody
    public void test(@PathVariable String table) {

        Entity entity = new Entity();
        entity.setCode("blog");
        entity.setName("CmsBlog");
        entity.setDisplayName("博客");
        entity.setTableName("CMS_BLOG");
        entity.setSystem("console");

        Attribute idAttr = new Attribute();
        idAttr.setColName("id");
        idAttr.setJavaType("Long");
        idAttr.setName("id");
        idAttr.setDisplayName("编号");
        idAttr.setId(true);
        entity.setIdAttribute(idAttr);

        Attribute nameAttr = new Attribute();
        nameAttr.setColName("title");
        nameAttr.setJavaType("String");
        nameAttr.setName("title");
        nameAttr.setDisplayName("标题");
        nameAttr.setShowInQuery(true);

        Attribute contentAttr = new Attribute();
        contentAttr.setColName("content");
        contentAttr.setJavaType("String");
        contentAttr.setName("content");
        contentAttr.setDisplayName("内容");
        contentAttr.setShowInQuery(true);

        Attribute createTimeAttr = new Attribute();
        createTimeAttr.setColName("create_time");
        createTimeAttr.setJavaType("Date");
        createTimeAttr.setName("createTime");
        createTimeAttr.setDisplayName("创建日期");
        createTimeAttr.setShowInQuery(true);

        Attribute createUserIdAttr = new Attribute();
        createUserIdAttr.setColName("create_user_id");
        createUserIdAttr.setJavaType("Long");
        createUserIdAttr.setName("createUserId");
        createUserIdAttr.setDisplayName("创建人");
        createUserIdAttr.setShowInQuery(true);

        Attribute typeAttr = new Attribute();
        typeAttr.setColName("type");
        typeAttr.setJavaType("String");
        typeAttr.setName("type");
        typeAttr.setDisplayName("博客类型");
        typeAttr.setShowInQuery(true);

        entity.getList().add(idAttr);
        entity.getList().add(nameAttr);
        entity.getList().add(contentAttr);
        entity.getList().add(createTimeAttr);
        entity.getList().add(createUserIdAttr);
        entity.getList().add(typeAttr);

        entity.setNameAttribute(nameAttr);
        entity.setComment("这是一个测试模型");
        // ConsoleTarget target = new ConsoleTarget();

        String basePackage = "com.ibeetl.admin.console";
        MavenProjectTarget target = new MavenProjectTarget(entity, basePackage);
        target.setUrlBase("admin");



    }

}

class EntityInfo {
    Entity entity;
    String urlBase;
    String basePackage;
    String nameAttr;

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public String getUrlBase() {
        return urlBase;
    }

    public void setUrlBase(String urlBase) {
        this.urlBase = urlBase;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getNameAttr() {
        return nameAttr;
    }

    public void setNameAttr(String nameAttr) {
        this.nameAttr = nameAttr;
    }

}
