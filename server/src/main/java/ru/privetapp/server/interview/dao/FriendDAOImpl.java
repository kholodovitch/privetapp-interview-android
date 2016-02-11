package ru.privetapp.server.interview.dao;

import java.util.List;

import org.hibernate.Criteria;
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
	public List<Friend> list(Integer offset, Integer count) {
		Session session = this.sessionFactory.openSession();
		try {
			Criteria criteria = session.createCriteria(Friend.class);
			if (offset != null)
				criteria.setFirstResult(offset);
			if (count != null)
				criteria.setMaxResults(count);

			return criteria.setReadOnly(true).list();
		} finally {
			session.close();
		}
	}
}
