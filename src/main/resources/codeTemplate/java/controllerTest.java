package  ${package};

import com.alibaba.fastjson.JSON;
import com.trj.usercenter.web.${entity.name}Controller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


\@RunWith(SpringRunner.class)
\@SpringBootTest
public class ${entity.name}ControllerTest {


    \@Autowired
    private ${entity.name}Controller  ${entity.code}Controller;

    \@Test
    public void findById(){
        System.out.println(JSON.toJSONString(${entity.code}Controller.findById(1)));
    }

    \@Test
    public void deleteById(){
        System.out.println(JSON.toJSONString(${entity.code}Controller.deleteById(1)));
    }
}