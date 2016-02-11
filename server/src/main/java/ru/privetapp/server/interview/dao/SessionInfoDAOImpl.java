package ru.privetapp.server.interview.dao;

import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ru.privetapp.server.interview.exceptions.InterviewServiceException;
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
			return (SessionInfo) session.get(SessionInfo.class, id.toString());
		} finally {
			session.close();
		}
	}

	@Override
	public UUID add(SessionInfo newSession) throws InterviewServiceException {
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		UUID newSessionId = null;
		try {
			tx = session.beginTransaction();
			newSessionId = UUID.fromString((String) session.save(newSession));
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw new InterviewServiceException(e);
		} finally {
			session.close();
		}
		return newSessionId;
	}

	@Override
	public void deactivateByUser(UUID userId) {
		Session session = this.sessionFactory.openSession();
		try {
			String hqlUpdate = "update SessionInfo set isActive = 0 where userId = :userId";
			session.createQuery(hqlUpdate).setString("userId", userId.toString()).executeUpdate();
		} finally {
			session.close();
		}
	}
}
