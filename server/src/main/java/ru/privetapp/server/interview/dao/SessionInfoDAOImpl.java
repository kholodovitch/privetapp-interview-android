package ru.privetapp.server.interview.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ru.privetapp.server.interview.models.SessionInfo;

public class SessionInfoDAOImpl implements SessionInfoDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public SessionInfo get(UUID id) {
		Session session = this.sessionFactory.openSession();
		try {
			Criteria criteria = session.createCriteria(SessionInfo.class).setMaxResults(1);
			List<SessionInfo> list = criteria.setReadOnly(true).list();
			return list.isEmpty() ? null : list.get(0);
		} finally {
			session.close();
		}
	}

	@Override
	public void add(SessionInfo newSession) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deactivateByUser(UUID userId) {
		// TODO Auto-generated method stub

	}
}
