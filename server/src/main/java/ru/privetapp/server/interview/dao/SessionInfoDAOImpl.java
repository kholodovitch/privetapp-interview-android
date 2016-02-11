package ru.privetapp.server.interview.dao;

import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ru.privetapp.server.interview.models.SessionInfo;

public class SessionInfoDAOImpl implements SessionInfoDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public SessionInfo get(UUID id) {
		Session session = this.sessionFactory.openSession();
		try {
			return (SessionInfo)session.get(SessionInfo.class, id.toString());
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
