package ${package};

import org.springframework.web.bind.annotation.GetMapping;
import com.trj.usercenter.domain.${entity.name};
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import ${basePackage}.service.*;
import com.trj.usercenter.tool.Results;
import com.trj.usercenter.tool.Result;

/**
 * ${entity.name} 控制器
 */
\@RestController
\@RequestMapping("/${entity.code}")
public class ${entity.name}Controller extends BaseController{

    @var service=entity.code+"Service";

    \@Autowired
    private ${entity.name}Service ${service};


   \@GetMapping("findById")
   public Result<${entity.name}> findById(Integer id) {
        return Results.newSuccessResult(${service}.findById(id));
   }


   \@GetMapping("deleteById")
   public Result<Boolean> deleteById(Integer id){
       int num = ${service}.deleteById(id);
       boolean result = num ==1 ?true:false;
       return Results.newSuccessResult(result);
   }



}
