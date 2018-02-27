package ${package};

import com.trj.usercenter.domain.${entity.name};
import com.trj.usercenter.mapper.${entity.name}Mapper;
import com.trj.usercenter.service.${entity.name}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ${entity.name}接口实现
 */
\@Service
public class ${entity.name}ServiceImpl implements ${entity.name}Service{

    @var mapper=entity.code+"Mapper";
    \@Autowired
    private ${entity.name}Mapper ${mapper};

    \@Override
    public ${entity.name} findById(Integer id) {
        return ${entity.code}Mapper.selectByPrimaryKey(id);
    }
}