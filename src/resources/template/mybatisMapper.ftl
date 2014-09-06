<?xml version="1.0" encoding="UTF-8" ?> 
<!DOCTYPE mapper 
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${packageName}.dao.${className}Dao">
	
	<resultMap type="${packageName}.domain.${className}DO" id="${className}Result">
		<#list properties as property>
			<<#if property_index == 0>id<#assign idName=property.popName><#assign idColumn=property.columnName><#else>result</#if> property="${property.popName}" column="${property.columnName}" />
		</#list>
	</resultMap>
	
	<sql id="${className?uncap_first}-query-columns">
		<#list properties as property>
			${property.columnName}<#if property_has_next >,</#if>
		</#list>
	</sql>
	
	<sql id="${className?uncap_first}-insert-columns">
		<#list properties as property>
			${property.columnName}<#if property_has_next >,</#if>
		</#list>
	</sql>

	<!-- select -->
	<select id="select${className}ById" parameterType="java.lang.Long" resultMap="${className}Result">
		SELECT 
			<include refid="${className}-query-columns"/>
		FROM 
			${tableName} 
		WHERE 
			${idColumn}=${'#'}{${idName}}
	</select>

	<select id="select${className}List" parameterType="${packageName}.bo.Query${className}BO" resultMap="${className}Result">
		SELECT 
			<include refid="${className?uncap_first}-query-columns"/> 
		FROM 
			${tableName}
		ORDER BY gmt_modified DESC
		LIMIT ${r"#{pageIndex}"}, ${r"#{pageSize}"}
	</select>
	
	<!-- insert -->
	<insert id="insert${className}" parameterType="${packageName}.domain.${className}DO"
		useGeneratedKeys="true" keyProperty="${idName}">
		INSERT INTO ${tableName}
		(
			<include refid="${className}-insert-columns"/>
		)VALUES(
			<#list properties as property>
			${'#'}{${property.popName}}<#if property_has_next >,</#if>
			</#list>
		)
	</insert>

	<!-- update -->
	<update id="update${className}" parameterType="${packageName}.${className}DO">
		UPDATE 
			${tableName}
		SET
			<#list properties as property>
			${property.columnName}=${'#'}{${property.popName}}<#if property_has_next >,</#if>
			</#list>
		WHERE 
			${idColumn}=${'#'}{${idName}}
	</update>
	
	<delete id="delete${className}" parameterType="${packageName}.${className}DO">
		DELETE FROM 
			${tableName}
		WHERE 
			${idColumn}=${'#'}{${idName}}
	</delete>

</mapper>
 No newline at end of file

