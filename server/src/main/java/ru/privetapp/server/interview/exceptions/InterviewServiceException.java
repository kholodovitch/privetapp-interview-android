package ru.privetapp.server.interview.exceptions;

import org.hibernate.HibernateException;

public class InterviewServiceException extends Exception {

	private static final long serialVersionUID = -5049313194827308329L;

	public InterviewServiceException() {
	}

	public InterviewServiceException(HibernateException e) {
		super(e);
	}

}
