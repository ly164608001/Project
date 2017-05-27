package ${package};

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ${className}业务逻辑层实现类
 * @author 
 * @date   ${createDate}
 */ 
@Service
public class ${className}ServiceImpl implements I${className}Service {
	@Autowired
	private ${className}Mapper <@lowerFC>${className}</@lowerFC>Mapper;
	 
	@Override
	public ${className} insert(${className} entity) {
		return <@lowerFC>${className}</@lowerFC>Mapper.insert(entity);
	}

	@Override
	public ${className} update(${className} entity) {
		return <@lowerFC>${className}</@lowerFC>Mapper.update(entity);
	}

	@Override
	public void delete(String id) {
		<@lowerFC>${className}</@lowerFC>Mapper.delete(id);
	}

	@Override
	public ${className} queryOne(String id) {
		return <@lowerFC>${className}</@lowerFC>Mapper.queryOne(id);
	}
	
}