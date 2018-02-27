package ${package};
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
\@RequestMapping("/${target.urlBase}")
public class ${entity.name}Controller extends BaseController{

    @var service=entity.code+"Service";

    \@Autowired
    private ${entity.name}Service ${service};

    /**
     * 根据Id查询Model
     * \@param  id 主键
     * \@return 模型实体
     */
    \@GetMapping("findById")
   public Result<${entity.name}> findById(Integer id) {
        return Results.newSuccessResult(${service}.findById(id));
    }



}
