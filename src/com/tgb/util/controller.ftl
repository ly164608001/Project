package ${package};

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ${className}控制层
 * 
 * @author 
 * @date  ${createDate}
 */
@Controller
@RequestMapping("/<@lowerFC>${className}</@lowerFC>")
public class ${className}Controller {

	@Autowired
	private I${className}Service <@lowerFC>${className}</@lowerFC>Service;

	@RequestMapping("/show${className}.do")
	public String show${className}(HttpServletRequest request,HttpServletResponse response) {
		return "/<@lowerFC>${className}</@lowerFC>/<@lowerFC>${className}</@lowerFC>Index";
	}

	@RequestMapping("/update${className}.do")
	public String update${className}(HttpServletRequest request,HttpServletResponse response) {
		request.getSession().setAttribute("id", request.getParameter("id"));
		return "/<@lowerFC>${className}</@lowerFC>/<@lowerFC>${className}</@lowerFC>Index";
	}

}
