<?xml version="1.0" encoding="utf-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" ><!-- 处理对 UAB_AGEN 表的操作 -->
<mapper namespace="com.tgb.mapper.${className}Mapper">

    <!-- 定义resultMap对象，将从数据库中取到的记录行对应到java对象. -->
    <resultMap id="${className}Map" type="${className}">
    <#list columns as column>
       <result property="${column.tableField}" column="${column.beanField}"/>
    </#list>
    </resultMap>

    <!-- 增加${className} -->
    <insert id="insert" parameterType="${className}"  flushCache="true" resultMap="${className}Map">
        INSERT INTO ${tableName}( 
             <#list columns as column>
             	<#if column_has_next>
             		${column.tableField},
             	</#if>
             	<#if !column_has_next>
             		${column.tableField}
             	</#if>
             </#list>
             ) 
         VALUES(
          	<#list columns as column>
             	<#if column_has_next>
             		${r'#{'}${column.beanField}${r'}'},
             	</#if>
             	<#if !column_has_next>
             		${r'#{'}${column.beanField}${r'}'}
             	</#if>
             </#list>
           )
    </insert>

    <!-- 根据id条件查询 -->
    <select id="queryOne" resultMap="${className}" parameterType="String" resultMap="${className}Map">
        SELECT 
			<#list columns as column>
             	<#if column_has_next>
             		${column.tableField},
             	</#if>
             	<#if !column_has_next>
             		${column.tableField}
             	</#if>
             </#list>
	    FROM ${tableName} WHERE  id = ${r'#{id}'}
    </select>
    
    <!-- 修改 -->
    <update id="update" parameterType="${className}"  flushCache="true" resultMap="${className}Map">
        UPDATE ${tableName}
            <set>
            	<#list columns as column>
	             	<if test="${column.beanField}!=null">${column.tableField}=${r'#{'}${column.beanField}${r'}'},</if>
             	</#list>
            </set> 
        <![CDATA[WHERE  ID = ${r'#{id}'}]]>
    </update>
    
    <!-- 删除 -->
    <delete id="delete" parameterType="String">
    	DELETE FROM ${tableName} WHERE FID = ${r'#{id}'}
    </delete>
    
</mapper>
