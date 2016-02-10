package ru.privetapp.server.interview.component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import ru.privetapp.server.interview.dao.FriendDAO;
import ru.privetapp.server.interview.models.Friend;
import ru.privetapp.server.interview.types.ListItems;

@Component
public class MainService implements IMainService {

	public UUID login(String email, String password) {
		return UUID.randomUUID();
	}

	@Override
	public ListItems[] list(Integer offset, Integer count) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		try {
			FriendDAO personDAO = context.getBean(FriendDAO.class);
			List<Friend> list = personDAO.list();
			List<ListItems> result = new ArrayList<ListItems>(list.size());

			for (Friend p : list) {
				ListItems item = new ListItems();
				item.setId(UUID.fromString(p.getUuid()));
				item.setTitle(p.getTitle());
				item.setUrl(p.getUrl());
				result.add(item);
			}
			return result.toArray(new ListItems[0]);
		} finally {
			context.close();
		}
	}

}
