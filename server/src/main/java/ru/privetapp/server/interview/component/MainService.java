package ru.privetapp.server.interview.component;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class MainService implements IMainService {

	public UUID login(String email, String password) {
		return UUID.randomUUID();
	}

}
