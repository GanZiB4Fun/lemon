package template.java_src.$

<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

<#include "/java_imports.include">
@Service
@Transactional
public class ${className}Manager extends BaseManager<${className},${table.idColumn.javaType}>{

	private ${className}Mapper ${classNameLower}Mapper;

	public void set${className}Mapper(${className}Mapper mapper) {
		this.${classNameLower}Mapper = mapper;
	}
	public EntityDao getEntityMapper() {
		return this.${classNameLower}Mapper;
	}
	
	@Transactional(readOnly=true)
	public Page findPage(${className}Query query) {
		return ${classNameLower}Mapper.findPage(query);
	}
	
<#list table.columns as column>
	<#if column.unique && !column.pk>
	@Transactional(readOnly=true)
	public ${className} getBy${column.columnName}(${column.javaType} v) {
		return ${classNameLower}Mapper.getBy${column.columnName}(v);
	}	
	
	</#if>
</#list>
}
