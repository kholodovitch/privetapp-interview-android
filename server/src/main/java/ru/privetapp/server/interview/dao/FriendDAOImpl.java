package ru.privetapp.server.interview.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ru.privetapp.server.interview.models.Friend;

public class FriendDAOImpl implements FriendDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Friend> list() {
		Session session = this.sessionFactory.openSession();
		try {
			return session.createCriteria(Friend.class).setReadOnly(true).list();
		} finally {
			session.close();
		}
	}

}
