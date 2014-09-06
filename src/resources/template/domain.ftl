package ${packageName}.domain;

<#list importPackage as imports>
import ${imports};
</#list>

public class ${className} {
	<#list properties as property>
	/**
	 * ${property.comment}
	 */
	private ${property.popType} ${property.popName};
	</#list>
	<#list properties as property>
	public ${property.popType} get${property.popName?cap_first}() {
		return ${property.popName};
	}
	public void set${property.popName?cap_first} (${property.popType} ${property.popName}) {
		this.${property.popName} = ${property.popName};
	}
	</#list>
}

