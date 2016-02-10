package ru.privetapp.server.interview.component;

import java.util.UUID;

public interface IMainService {
	public UUID login(String email, String password);
}
