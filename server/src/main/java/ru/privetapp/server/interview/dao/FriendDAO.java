package ru.privetapp.server.interview.dao;

import java.util.List;

import ru.privetapp.server.interview.models.Friend;

public interface FriendDAO {

	public List<Friend> list(Integer offset, Integer count);

}
