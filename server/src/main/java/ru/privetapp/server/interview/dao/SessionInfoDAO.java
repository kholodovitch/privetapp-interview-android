package ru.privetapp.server.interview.dao;

import java.util.UUID;

import ru.privetapp.server.interview.models.SessionInfo;

public interface SessionInfoDAO {

	public SessionInfo get(UUID id);

	public void add(SessionInfo newSession);

	public void deactivateByUser(UUID userId);

}
