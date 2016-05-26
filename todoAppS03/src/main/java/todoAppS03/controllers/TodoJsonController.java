package todoAppS03.controllers;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import todoAppS03.dto.TodoDTO;
import todoAppS03.entities.TodoEntity;
import todoAppS03.gateways.TodoGateway;

@Controller
public class TodoJsonController {
	
	@Autowired
	private TodoGateway todoGateway;

	@RequestMapping("json-todo/{todoId}")
	public @ResponseBody TodoDTO getFakeTodo(@PathVariable String todoId) {
		TodoDTO result = new TodoDTO();
		TodoEntity entity = todoGateway.getById(todoId);
		if (entity != null)
		{
			result.id = entity.getId().toString();
			result.name = entity.getName();
		}
		else
		{
			result.name = "Todo not found";
			result.id = "42";
		}
		return result;
	}

	
}
