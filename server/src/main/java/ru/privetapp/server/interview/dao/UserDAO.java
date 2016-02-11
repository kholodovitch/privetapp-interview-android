package ru.privetapp.server.interview.dao;

import ru.privetapp.server.interview.models.User;

public interface UserDAO {

	public User get(String login, String pass);

}
