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
 * <p>Description:自定义宏首字母小写</p>
 * @author Administrator
 * @date 2017年5月27日 下午1:51:24
 */
public class LowerFirstCharacter implements TemplateDirectiveModel{

	@Override
	public void execute(Environment env,  
            Map params, TemplateModel[] loopVars,  
            TemplateDirectiveBody body)
			throws TemplateException, IOException {
		if  (body !=  null ) {  
            body.render(new  LowerCaseFilterWriter(env.getOut()));  
        } else  {  
            throw   new  RuntimeException( "missing body" );  
        }  
	}
	
	private   static   class  LowerCaseFilterWriter  extends  Writer {
		
		private   final  Writer out;  
        
		LowerCaseFilterWriter (Writer out) {  
            this .out = out;  
        }  
		@Override
		public void write(char[] cbuf, int off, int len) throws IOException {
			cbuf[0] = Character.toLowerCase(cbuf[0]);
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
