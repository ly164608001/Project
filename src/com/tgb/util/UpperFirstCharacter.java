package com.tgb.util;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * <p>Description:freemarker中不支持将首字母大写(属性名中用到)，那么自己先写一个自定义宏</p>
 * @author Administrator
 * @date 2017年5月27日 下午1:51:24
 */
public class UpperFirstCharacter implements TemplateDirectiveModel{

	@Override
	public void execute(Environment env,  
            Map params, TemplateModel[] loopVars,  
            TemplateDirectiveBody body)
			throws TemplateException, IOException {
		if  (body !=  null ) {  
            body.render(new  UpperCaseFilterWriter(env.getOut()));  
        } else  {  
            throw   new  RuntimeException( "missing body" );  
        }  
	}
	
	private   static   class  UpperCaseFilterWriter  extends  Writer {
		
		private   final  Writer out;  
        
        UpperCaseFilterWriter (Writer out) {  
            this .out = out;  
        }  
		@Override
		public void write(char[] cbuf, int off, int len) throws IOException {
			cbuf[0] = Character.toUpperCase(cbuf[0]);
			out.write(String.valueOf(cbuf).trim());
		}

		@Override
		public void flush() throws IOException {
			
		}

		@Override
		public void close() throws IOException {
		}  
		
	}

}
