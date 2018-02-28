package com.trj.usercenter.controller;

import com.alibaba.fastjson.JSON;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.trj.usercenter.core.gen.model.TableRoot;
import com.trj.usercenter.core.web.CoreCodeGenController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author xierongli
 * @version $$Id: usercenter, v 0.1 18/2/24 下午6:17 mark1xie Exp $$
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CoreCodeGenControllerTest {
    @Autowired
    private CoreCodeGenController coreCodeGenController;

    @Test
    public void getInfo(){
        System.out.println(JSON.toJSONString(coreCodeGenController.gen("customer")));
    }

    @Test
    public void test(){
        try {
            File dataXml = new File(ResourceUtils.getURL("classpath:codeGenerateConfig.xml").getPath());
            XStream xstream = new XStream(new DomDriver());
            xstream.autodetectAnnotations(true);
            xstream.processAnnotations(TableRoot.class);
            TableRoot tableRoot = (TableRoot) xstream.fromXML(dataXml);

            System.out.println(JSON.toJSONString(tableRoot));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
