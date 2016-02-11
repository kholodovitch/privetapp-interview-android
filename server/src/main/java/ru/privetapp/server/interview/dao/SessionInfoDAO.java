package ru.privetapp.server.interview.dao;

import java.util.UUID;

import ru.privetapp.server.interview.exceptions.InterviewServiceException;
import ru.privetapp.server.interview.models.SessionInfo;

public interface SessionInfoDAO {

	public SessionInfo get(UUID id);

	public UUID add(SessionInfo newSession) throws InterviewServiceException;

	public void deactivateByUser(UUID userId);

}
