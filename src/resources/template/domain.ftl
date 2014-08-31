package ${modelBean.packageName}.domain;

<#list modelBean.importPackage as importPackage>
import ${importPackage};
</#list>

public class ${modelBean.className} {
	<#list modelBean.properties as property>
	/**
	 * ${property.comment}
	 */
	private ${property.popType} ${property.popName};
	</#list>
	<#list modelBean.properties as property>
	public ${property.popType} get${property.popName?cap_first}() {
		return ${property.popName};
	}
	public void set${property.popName?cap_first} (${property.popType} ${property.popName}) {
		this.${property.popName} = ${property.popName};
	}
	</#list>
}
