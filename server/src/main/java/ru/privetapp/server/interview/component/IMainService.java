package ru.privetapp.server.interview.component;

import java.util.UUID;

import ru.privetapp.server.interview.types.ListItems;

public interface IMainService {
	public UUID login(String email, String password);

	public ListItems[] list(Integer offset, Integer count);
}
