/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package ${packageUrl}.dao;


import ${packageUrl}.domain.${className}DO;
import ${packageUrl}.bo.Query${className}BO;

public class ${ClassName}Dao {

	/**
     * @param select${className}ById
     * @return
     */
	public ${ClassName}DO select${className}ById(Long id);
	/**
     * @param select${className}List
     * @return
     */
    public List<${ClassName}DO> select${className}List(Query${className}BO query);
	
	public int 
}

