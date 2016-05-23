package todoAppS03;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TodoControllerBean {
	
	@RequestMapping("hello")
	public ResponseEntity<String> helloHandler() {
		return new ResponseEntity<>("<h1>hello spring</h1>", HttpStatus.OK);
	}
}
