package ru.privetapp.server.interview.exceptions;

public class InterviewServiceException extends Exception {

	private static final long serialVersionUID = -5049313194827308329L;

	public InterviewServiceException(String msg) {
		super(msg);
	}

	public InterviewServiceException(String msg, Exception e) {
		super(msg, e);
	}

}
