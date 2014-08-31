<?xml version="1.0" encoding="UTF-8" ?> 
<!DOCTYPE mapper 
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${modelBean.packageUrl}.dao.${modelBean.className}Dao">
	
	<resultMap type="${modelBean.packageUrl}.domain.${modelBean.className}DO" id="${modelBean.className}Result">
		<#list modelBean.properties as property>
			<<#if property_index == 0>id<#assign idName=property.popName><#assign idColumn=property.columnName><#else>result</#if> property="${property.popName}" column="${property.columnName}" />
		</#list>
	</resultMap>
	
	<sql id="${modelBean.className?uncap_first}-query-columns">
		<#list modelBean.properties as property>
			${property.columnName}<#if property_has_next >,</#if>
		</#list>
	</sql>
	
	<sql id="${modelBean.className?uncap_first}-insert-columns">
		<#list modelBean.properties as property>
			${property.columnName}<#if property_has_next >,</#if>
		</#list>
	</sql>

	<!-- select -->
	<select id="select${modelBean.className}ById" parameterType="java.lang.Long" resultMap="${modelBean.className}Result">
		SELECT 
			<include refid="${modelBean.className}-query-columns"/>
		FROM 
			${modelBean.tableName} 
		WHERE 
			${idColumn}=${'#'}{${idName}}
	</select>

	<select id="select${modelBean.className}List" parameterType="${modelBean.packageUrl}.bo.Query${modelBean.className}BO" resultMap="${modelBean.className}Result">
		SELECT 
			<include refid="${modelBean.className?uncap_first}-query-columns"/> 
		FROM 
			${modelBean.tableName}
		ORDER BY gmt_modified DESC
		LIMIT ${r"#{pageIndex}"}, ${r"#{pageSize}"}
	</select>
	
	<!-- insert -->
	<insert id="insert${modelBean.className}" parameterType="${modelBean.packageUrl}.domain.${modelBean.className}DO"
		useGeneratedKeys="true" keyProperty="${idName}">
		INSERT INTO ${modelBean.tableName}
		(
			<include refid="${modelBean.className}-insert-columns"/>
		)VALUES(
			<#list modelBean.properties as property>
			${'#'}{${property.popName}}<#if property_has_next >,</#if>
			</#list>
		)
	</insert>

	<!-- update -->
	<update id="update${modelBean.className}" parameterType="${modelBean.packageUrl}.${modelBean.className}DO">
		UPDATE 
			${modelBean.tableName}
		SET
			<#list modelBean.properties as property>
			${property.columnName}=${'#'}{${property.popName}}<#if property_has_next >,</#if>
			</#list>
		WHERE 
			${idColumn}=${'#'}{${idName}}
	</update>
	
	<delete id="delete${modelBean.className}" parameterType="${modelBean.packageUrl}.${modelBean.className}DO">
		DELETE FROM 
			${modelBean.tableName}
		WHERE 
			${idColumn}=${'#'}{${idName}}
	</delete>

</mapper>