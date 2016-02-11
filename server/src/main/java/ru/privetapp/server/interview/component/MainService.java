package ru.privetapp.server.interview.component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import ru.privetapp.server.interview.dao.FriendDAO;
import ru.privetapp.server.interview.dao.SessionInfoDAO;
import ru.privetapp.server.interview.dao.UserDAO;
import ru.privetapp.server.interview.exceptions.AuthorizationException;
import ru.privetapp.server.interview.exceptions.InterviewServiceException;
import ru.privetapp.server.interview.exceptions.SessionNotFoundException;
import ru.privetapp.server.interview.models.Friend;
import ru.privetapp.server.interview.models.SessionInfo;
import ru.privetapp.server.interview.models.User;
import ru.privetapp.server.interview.types.ListItems;

@Component
public class MainService implements IMainService {

	public UUID login(String email, String password) throws InterviewServiceException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		try {
			UserDAO userDAO = context.getBean(UserDAO.class);
			SessionInfoDAO sessionDAO = context.getBean(SessionInfoDAO.class);
			User user = userDAO.get(email, password);
			if (user == null)
				throw new AuthorizationException();

			SessionInfo newSessionInfo = new SessionInfo();
			newSessionInfo.setUuid(UUID.randomUUID().toString());
			newSessionInfo.setUserId(user.getUuid());
			newSessionInfo.setActive(true);

			sessionDAO.deactivateByUser(UUID.fromString(user.getUuid()));
			return sessionDAO.add(newSessionInfo);
		} finally {
			context.close();
		}
	}

	@Override
	public ListItems[] list(String sessionId, Integer offset, Integer count) throws InterviewServiceException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		try {
			SessionInfoDAO sessionDAO = context.getBean(SessionInfoDAO.class);
			SessionInfo sessionInfo = sessionDAO.get(UUID.fromString(sessionId));
			if (sessionInfo == null)
				throw new SessionNotFoundException();
			if (!sessionInfo.isActive())
				throw new SessionExpiredException();

			FriendDAO friendDAO = context.getBean(FriendDAO.class);
			List<Friend> list = friendDAO.list(offset, count);
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
