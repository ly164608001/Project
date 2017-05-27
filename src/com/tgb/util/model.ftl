package  ${package};  
  
import  java.util.Date;  
import  com.tgb.model.BaseEntity;
import  java.io.Serializable;  
/**
 * ${className}实体类
 * @author 
 * @date   ${createDate}
 */
public   class  ${className} extends BaseEntity implements  Serializable{  
<#list properties as fieldInfo>  
    private  ${fieldInfo.fieldType} ${fieldInfo.fieldName};  
</#list>  
      
<#list properties as fieldInfo>  
    public   void  set<@upperFC>${fieldInfo.fieldName}</@upperFC>(${fieldInfo.fieldType} ${fieldInfo.fieldName}){  
        this.${fieldInfo.fieldName}=${fieldInfo.fieldName};  
    }  
      
    public  ${fieldInfo.fieldType} get<@upperFC>${fieldInfo.fieldName}</@upperFC>(){  
        return   this.${fieldInfo.fieldName};  
    }  
</#list>  

	public ${className}(){}
	public ${className}(
<#list properties as fieldInfo> 
 	<#if !fieldInfo_has_next>
 		${fieldInfo.fieldType} ${fieldInfo.fieldName}
 	</#if>
 	<#if fieldInfo_has_next>
 		${fieldInfo.fieldType} ${fieldInfo.fieldName},
 	</#if>
</#list>
						){
			super();
		<#list properties as fieldInfo>
			this.${fieldInfo.fieldName} = ${fieldInfo.fieldName};
		</#list> 
	}
}  