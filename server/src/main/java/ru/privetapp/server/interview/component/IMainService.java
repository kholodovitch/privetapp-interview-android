package ru.privetapp.server.interview.component;

import java.util.UUID;

import ru.privetapp.server.interview.exceptions.InterviewServiceException;
import ru.privetapp.server.interview.types.ListItems;

public interface IMainService {
	public UUID login(String email, String password) throws InterviewServiceException;

	public ListItems[] list(String sessionId, Integer offset, Integer count);
}
