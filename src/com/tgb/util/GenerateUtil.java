package com.tgb.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 代码生成工具类
 * @author Administrator
 *
 */
public class GenerateUtil {
	private static Configuration cfg = new  Configuration();
	/**
	 * 实体类生成
	 * @throws IOException 
	 */
	public static void generateModelFile(ResultSet resultSet,String tableName) throws Exception, IOException{
		cfg.setClassForTemplateLoading(GenerateUtil.class, "" );
		cfg.setSharedVariable("upperFC",new UpperFirstCharacter());
		cfg.setSharedVariable("lowerFC",new LowerFirstCharacter());
		cfg.setDefaultEncoding("UTF-8");
		Template t = cfg.getTemplate("model.ftl" ); //指定模板
		t.setEncoding("UTF-8");
		File file = new  File( "d:/com/tgb/model");
		if(!file.exists()){
			file.mkdirs();
		}
		FileOutputStream fos = new  FileOutputStream(new File("d:/com/tgb/model/"+FieldUtil.toUpperCase4Index(FieldUtil.transFiledName(tableName))+".java") );
		Map data = new HashMap();
		List list = new ArrayList(); 
		Map map = null;
		while(resultSet.next()){
			map = new HashMap();
			map.put("fieldName",FieldUtil.transFiledName(resultSet.getString("COLUMN_NAME")));
			map.put("fieldType",GenerateUtil.transFieldType(resultSet.getString("TYPE_NAME")));
			list.add(map);
		}
		data.put("package","com.tgb.model");
		data.put("className",FieldUtil.toUpperCase4Index(FieldUtil.transFiledName(tableName)));
		data.put("createDate",new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		data.put("properties",list);
		t.process(data, new  OutputStreamWriter(fos, "utf-8" )); //   
        fos.flush();  
        fos.close();  
	}
	
	/**
	 * Dao生成
	 * @throws IOException 
	 */
	public static void generateDaoFile(String tableName) throws Exception{
		cfg.setClassForTemplateLoading(GenerateUtil.class, "" );
		cfg.setSharedVariable("upperFC",new UpperFirstCharacter());
		cfg.setSharedVariable("lowerFC",new LowerFirstCharacter());
		cfg.setDefaultEncoding("UTF-8");
		Template t = cfg.getTemplate("dao.ftl" ); //指定模板
		t.setEncoding("UTF-8");
		File file = new  File( "d:/com/tgb/mapper");
		if(!file.exists()){
			file.mkdirs();
		}
		FileOutputStream fos = new  FileOutputStream(new File("d:/com/tgb/mapper/"+FieldUtil.toUpperCase4Index(FieldUtil.transFiledName(tableName))+"Mapper.java") );
		Map data = new HashMap();
		List list = new ArrayList(); 
		data.put("package","com.tgb.mapper");
		data.put("className",FieldUtil.toUpperCase4Index(FieldUtil.transFiledName(tableName)));
		data.put("createDate",new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		t.process(data, new  OutputStreamWriter(fos, "utf-8" )); //   
        fos.flush();  
        fos.close();  
	}
	
	
	/**
	 * service生成
	 * @throws IOException 
	 */
	public static void generateServiceFile(String tableName) throws Exception{
		cfg.setClassForTemplateLoading(GenerateUtil.class, "" );
		cfg.setSharedVariable("upperFC",new UpperFirstCharacter());
		cfg.setSharedVariable("lowerFC",new LowerFirstCharacter());
		cfg.setDefaultEncoding("UTF-8");
		Template t = cfg.getTemplate("service.ftl" ); //指定模板
		t.setEncoding("UTF-8");
		File file = new  File( "d:/com/tgb/service");
		if(!file.exists()){
			file.mkdirs();
		}
		FileOutputStream fos = new  FileOutputStream(new File("d:/com/tgb/service/I"+FieldUtil.toUpperCase4Index(FieldUtil.transFiledName(tableName))+"Service.java") );
		Map data = new HashMap();
		List list = new ArrayList(); 
		data.put("package","com.tgb.service");
		data.put("className",FieldUtil.toUpperCase4Index(FieldUtil.transFiledName(tableName)));
		data.put("createDate",new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		t.process(data, new  OutputStreamWriter(fos, "utf-8" )); //   
        fos.flush();  
        fos.close();  
	}
	
	/**
	 * serviceImpl生成
	 * @throws IOException 
	 */
	public static void generateServiceImplFile(String tableName) throws Exception{
		cfg.setClassForTemplateLoading(GenerateUtil.class, "" );
		cfg.setSharedVariable("upperFC",new UpperFirstCharacter());
		cfg.setSharedVariable("lowerFC",new LowerFirstCharacter());
		cfg.setDefaultEncoding("UTF-8");
		Template t = cfg.getTemplate("serviceimpl.ftl" ); //指定模板
		t.setEncoding("UTF-8");
		File file = new  File( "d:/com/tgb/service/impl");
		if(!file.exists()){
			file.mkdirs();
		}
		FileOutputStream fos = new  FileOutputStream(new File("d:/com/tgb/service/impl/"+FieldUtil.toUpperCase4Index(FieldUtil.transFiledName(tableName))+"ServiceImpl.java") );
		Map data = new HashMap();
		List list = new ArrayList(); 
		data.put("package","com.tgb.service.impl");
		data.put("className",FieldUtil.toUpperCase4Index(FieldUtil.transFiledName(tableName)));
		data.put("createDate",new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		t.process(data, new  OutputStreamWriter(fos, "utf-8" )); //   
        fos.flush();  
        fos.close();  
	}
	
	
	/**
	 * controller生成
	 * @throws IOException 
	 */
	public static void generateControllerFile(String tableName) throws Exception{
		cfg.setClassForTemplateLoading(GenerateUtil.class, "" );
		cfg.setSharedVariable("upperFC",new UpperFirstCharacter());
		cfg.setSharedVariable("lowerFC",new LowerFirstCharacter());
		cfg.setDefaultEncoding("UTF-8");
		Template t = cfg.getTemplate("controller.ftl" ); //指定模板
		t.setEncoding("UTF-8");
		File file = new  File( "d:/com/tgb/controller");
		if(!file.exists()){
			file.mkdirs();
		}
		FileOutputStream fos = new  FileOutputStream(new File("d:/com/tgb/controller/"+FieldUtil.toUpperCase4Index(FieldUtil.transFiledName(tableName))+"Controller.java") );
		Map data = new HashMap();
		List list = new ArrayList(); 
		data.put("package","com.tgb.controller");
		data.put("className",FieldUtil.toUpperCase4Index(FieldUtil.transFiledName(tableName)));
		data.put("createDate",new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		t.process(data, new  OutputStreamWriter(fos, "utf-8" )); //   
        fos.flush();  
        fos.close();  
	}
	
	
	/**
	 * jsonController生成
	 * @throws IOException 
	 */
	public static void generateJsonControllerFile(String tableName) throws Exception{
		cfg.setClassForTemplateLoading(GenerateUtil.class, "" );
		cfg.setSharedVariable("upperFC",new UpperFirstCharacter());
		cfg.setSharedVariable("lowerFC",new LowerFirstCharacter());
		cfg.setDefaultEncoding("UTF-8");
		Template t = cfg.getTemplate("jsonController.ftl" ); //指定模板
		t.setEncoding("UTF-8");
		File file = new  File( "d:/com/tgb/json/controller");
		if(!file.exists()){
			file.mkdirs();
		}
		FileOutputStream fos = new  FileOutputStream(new File("d:/com/tgb/json/controller/json"+FieldUtil.toUpperCase4Index(FieldUtil.transFiledName(tableName))+"JsonController.java") );
		Map data = new HashMap();
		List list = new ArrayList(); 
		data.put("package","com.tgb.json.controller");
		data.put("className",FieldUtil.toUpperCase4Index(FieldUtil.transFiledName(tableName)));
		data.put("createDate",new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		t.process(data, new  OutputStreamWriter(fos, "utf-8" )); //   
        fos.flush();  
        fos.close();  
	}
	
	
	/**
	 * mapper生成
	 * @throws IOException 
	 */
	public static void generateMapperFile(ResultSet resultSet,String tableName) throws Exception, IOException{
		cfg.setClassForTemplateLoading(GenerateUtil.class, "" );
		cfg.setSharedVariable("upperFC",new UpperFirstCharacter());
		cfg.setSharedVariable("lowerFC",new LowerFirstCharacter());
		cfg.setDefaultEncoding("UTF-8");
		Template t = cfg.getTemplate("mapper.ftl" ); //指定模板
		t.setEncoding("UTF-8");
		File file = new  File( "d:/com/tgb/mapper");
		if(!file.exists()){
			file.mkdirs();
		}
		FileOutputStream fos = new  FileOutputStream(new File("d:/com/tgb/mapper/"+FieldUtil.toUpperCase4Index(FieldUtil.transFiledName(tableName))+"Mapper.xml") );
		Map data = new HashMap();
		List list = new ArrayList(); 
		Map map = null;
		while(resultSet.next()){
			map = new HashMap();
			map.put("beanField",FieldUtil.transFiledName(resultSet.getString("COLUMN_NAME")));
			map.put("tableField",resultSet.getString("COLUMN_NAME"));
			list.add(map);
		}
		data.put("package","com.tgb.mapper");
		data.put("className",FieldUtil.toUpperCase4Index(FieldUtil.transFiledName(tableName)));
		data.put("columns",list);
		data.put("tableName",tableName);
		t.process(data, new  OutputStreamWriter(fos, "utf-8" )); //   
        fos.flush();  
        fos.close();  
	}
	
	/**
	 * 将数据库字段类型转换成对应的Javabean类型
	 */
	public static String transFieldType(String fieldType){
		String type = "String";
		switch (fieldType) {
		case "VARCHAR":
			type = "String";
			break;
		case "TINYINT":
			type = "Integer";
			break;
		case "SMALLINT":
			type = "Integer";
			break;
		case "INTEGER":
			type = "Integer";
			break;
		case "FLOAT":
			type = "Float";
			break;
		case "DOUBLE":
			type = "Double";
			break;
		case "DECIMAL":
			type = "Double";
			break;
		case "DATE":
			type = "Date";
			break;
		case "DATETIME":
			type = "Date";
			break;
		case "TIMESTAMP":
			type = "Date";
			break;
		}
		return type;
	}
}
