package com.tgb.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tgb.model.BaseEntity;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class TestUnit {
	public static void main(String[] args) throws Exception {
		Configuration cfg = new  Configuration();  
		cfg.setClassForTemplateLoading(TestUnit.class,  "" );
		//cfg.setServletContextForTemplateLoading(,);
		cfg.setSharedVariable("upperFC",new UpperFirstCharacter());
		cfg.setSharedVariable("lowerFC",new LowerFirstCharacter());
		Template t = cfg.getTemplate("mapper.ftl" ); //指定模板
		File file = new  File( "d:/aa/");
		if(!file.exists()){
			file.mkdirs();
		}
		FileOutputStream fos = new  FileOutputStream(new File("d:/aa/test.java") );
		//模拟数据源   
        Map data = new  HashMap();  
        data.put("package" ,  "edu" ); //包名   
        data.put("className" ,  "Student" ); 
        data.put("createDate", "2017-05-27");
          
        List pros = new  ArrayList();  
        Map pro_1 = new  HashMap();  
        pro_1.put("fieldType" , String. class .getSimpleName());  
        pro_1.put("fieldName" ,  "name" );  
        pros.add(pro_1);  
          
        Map pro_2 = new  HashMap();  
        pro_2.put("fieldType" , String. class .getSimpleName());  
        pro_2.put("fieldName" ,  FieldUtil.transFiledName("sex_Test") );  
        pros.add(pro_2);  
        data.put("properties" , pros);  
        t.process(data, new  OutputStreamWriter(fos, "utf-8" )); //   
        fos.flush();  
        fos.close();  
	}
}
