package ru.privetapp.server.interview.messages;

import java.util.UUID;

public class LoginResponse extends BaseResponse {
	private UUID sessionId;

	public UUID getSessionId() {
		return sessionId;
	}

	public void setSessionId(UUID sessionId) {
		this.sessionId = sessionId;
	}
}
