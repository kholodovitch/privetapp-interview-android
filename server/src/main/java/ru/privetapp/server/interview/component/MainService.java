package ru.privetapp.server.interview.component;

import java.util.UUID;

import org.springframework.stereotype.Component;

import ru.privetapp.server.interview.types.ListItems;

@Component
public class MainService implements IMainService {

	public UUID login(String email, String password) {
		return UUID.randomUUID();
	}

	@Override
	public ListItems[] list(Integer offset, Integer count) {
		// TODO Auto-generated method stub
		return null;
	}

}
