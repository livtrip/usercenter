package com.trj.usercenter.core.web;

import com.trj.usercenter.core.gen.JavaCodeGen;
import com.trj.usercenter.core.gen.MavenProjectTarget;
import com.trj.usercenter.core.gen.model.Entity;
import com.trj.usercenter.core.gen.model.Table;
import com.trj.usercenter.core.gen.model.TableRoot;
import com.trj.usercenter.core.service.CoreCodeGenService;
import com.trj.usercenter.tool.Result;
import com.trj.usercenter.tool.Results;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class CoreCodeGenController {
    private final Log log = LogFactory.getLog(this.getClass());
    private static final String MODEL = "/core/codeGen";

    @Autowired
    CoreCodeGenService codeGenService;

    @PostMapping(MODEL + "/gen.json")
    @ResponseBody
    public Result<Boolean> gen() {
        String basePackage ="com.trj.usercenter";
        TableRoot tableRoot = codeGenService.getTableConfig();
        if(tableRoot != null){
            List<Table> tableList = tableRoot.getTableList();
            if(CollectionUtils.isNotEmpty(tableList)){
                for(Table table : tableList){
                    Entity entity = codeGenService.getEntityInfo(table.getTableName());
                    entity.setTable(table);
                    MavenProjectTarget target = new MavenProjectTarget(entity, basePackage);
                    target.setUrlBase("");
                    JavaCodeGen javaGen = new JavaCodeGen(basePackage, entity);
                    javaGen.make(target, entity);
                }
            }
        }
        return Results.newSuccessResult(true);

    }




}


