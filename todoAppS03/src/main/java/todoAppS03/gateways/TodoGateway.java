package todoAppS03.gateways;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import todoAppS03.entities.TodoEntity;

@Repository
public class TodoGateway {
	
	@Autowired
	private SessionFactory factory;
	
	@Transactional
	public TodoEntity getById(String todoId) {
		Session session = factory.getCurrentSession();
		Criteria qm = session.createCriteria(TodoEntity.class);
		qm.add(Restrictions.eq("id", todoId));
		@SuppressWarnings("unchecked")
		List<TodoEntity> list = qm.list();
		if (list.size() > 0)
		{
			return list.get(0);
		}
		return null;
	}
}
