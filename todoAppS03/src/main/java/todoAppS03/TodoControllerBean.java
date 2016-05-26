package todoAppS03;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TodoControllerBean {
	
	@RequestMapping("/hello")
	public ResponseEntity<String> helloHandler() {
		return new ResponseEntity<>("<h1>hello spring</h1>", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/static-jsp", method = RequestMethod.GET)
	public String jspHandler() {
		return "/WEB-INF/site/static.jsp";
	}
	
	@RequestMapping("/model-view-jsp")
	public ModelAndView mvHandler() {
		return new ModelAndView("/WEB-INF/site/static.jsp");
	}
}
