package todoAppS03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import todoAppS03.dto.TodoDTO;

@Controller
public class TodoJsonController {
	
	@RequestMapping("json-todo")
	public @ResponseBody TodoDTO getFakeTodo() {
		TodoDTO result = new TodoDTO();
		result.name = "make json todo";
		result.id = 42;
		return result;
	}
}
