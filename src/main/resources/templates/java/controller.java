package ${package};

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.ibeetl.admin.core.annotation.Function;
import com.ibeetl.admin.core.annotation.Query;
import com.ibeetl.admin.core.web.JsonResult;
import com.ibeetl.admin.core.util.*;
import ${basePackage}.entity.*;
import ${basePackage}.service.*;
import ${basePackage}.web.query.*;

/**
 * ${entity.displayName} 接口
 */
\@Controller
public class ${entity.name}Controller{

    private final Log log = LogFactory.getLog(this.getClass());
    private static final String MODEL = "/${target.urlBase}/${entity.code}";

    @var service=entity.code+"Service";

    \@Autowired
    private ${entity.name}Service ${service};

    /* 页面 */
    \@GetMapping(MODEL + "/index.do")
    \@Function("${entity.code}.query")
    \@ResponseBody
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("/${target.urlBase}/${entity.code}/index.html") ;
        view.addObject("search", ${entity.name}Query.class.getName());
        return view;
    }



}
