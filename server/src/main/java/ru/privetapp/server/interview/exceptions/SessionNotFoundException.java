package ru.privetapp.server.interview.exceptions;

public class SessionNotFoundException extends InterviewServiceException {

	private static final long serialVersionUID = -8443537013637950987L;

	public SessionNotFoundException() {
		super("Session not found");
	}

}
