package ${package};

import ${basePackage}.domain.*;
/**
 * ${entity.name}接口定义
 */
public interface ${entity.name}Service {

    ${entity.name} findById(Integer id);

    int deleteById(Integer id);

}