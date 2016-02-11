package ru.privetapp.server.interview.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ru.privetapp.server.interview.models.User;

public class UserDAOImpl implements UserDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User get(String login, String pass) {
		Session session = this.sessionFactory.openSession();
		try {
			Criteria criteria = session.createCriteria(User.class).setMaxResults(1);
			List<User> list = criteria.setReadOnly(true).list();
			return list.isEmpty() ? null : list.get(0);
		} finally {
			session.close();
		}
	}
}
