/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package ${modelBean.packageUrl}.dao;


import ${modelBean.packageUrl}.domain.${modelBean.className}DO;
import ${modelBean.packageUrl}.bo.Query${modelBean.className}BO;

public class ${ClassName}Dao {

	/**
     * @param select${modelBean.className}ById
     * @return
     */
	public ${ClassName}DO select${modelBean.className}ById(Long id);
	/**
     * @param select${modelBean.className}List
     * @return
     */
    public List<${ClassName}DO> select${modelBean.className}List(Query${modelBean.className}BO query);
	
	public int 
}
