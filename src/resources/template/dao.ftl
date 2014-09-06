/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package ${packageName}.dao;


import ${packageName}.domain.${packageName}DO;
import ${packageName}.bo.Query${packageName}BO;

public class ${className}Dao {

	/**
     * @param select${className}ById
     * @return
     */
	public ${className}DO select${className}ById(Long id);
	/**
     * @param select${className}List
     * @return
     */
    public List<${className}DO> select${className}List(Query${className}BO query);
	
}

