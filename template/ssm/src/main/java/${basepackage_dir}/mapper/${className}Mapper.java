package template.java_src.$

<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
        package ${basepackage}.mapper;

<#include "/java_imports.include">

import org.springframework.stereotype.Repository;

@Repository
public interface ${className}Mapper extends BaseMapper<${className},${className}Query>{

}
