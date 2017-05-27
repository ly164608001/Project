package ${package};

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * ${className}控制层（涉及数据）
 * 
 * @author 
 * @date  ${createDate}
 */
@Controller
@RequestMapping("/json${className}")
public class ${className}JsonController {

	@Autowired
	private I${className}Service <@lowerFC>${className}</@lowerFC>Service;

	@RequestMapping("/get${className}ById.do")
	@ResponseBody
	public ${className} get${className}ById(HttpServletRequest request,HttpServletResponse response) {
		return <@lowerFC>${className}</@lowerFC>Service.queryOne(request.getParameter("id"));
	}

	@RequestMapping("/save${className}.do")
	@ResponseBody
	public ${className} save${className}(HttpServletRequest request,HttpServletResponse response,${className} <@lowerFC>${className}</@lowerFC>) {
		return <@lowerFC>${className}</@lowerFC>Service.insert(<@lowerFC>${className}</@lowerFC>);
	}
	
	@RequestMapping("/update${className}.do")
	@ResponseBody
	public ${className} update${className}(HttpServletRequest request,HttpServletResponse response,${className} <@lowerFC>${className}</@lowerFC>) {
		return <@lowerFC>${className}</@lowerFC>Service.update(<@lowerFC>${className}</@lowerFC>);
	}
	
	@RequestMapping("/delete${className}.do")
	@ResponseBody
	public void delete${className}(HttpServletRequest request,HttpServletResponse response) {
		 <@lowerFC>${className}</@lowerFC>Service.delete(request.getParameter("id"));
	}
	

}
