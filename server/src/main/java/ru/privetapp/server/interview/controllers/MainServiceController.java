package ru.privetapp.server.interview.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.privetapp.server.interview.component.IMainService;
import ru.privetapp.server.interview.exceptions.InterviewServiceException;
import ru.privetapp.server.interview.messages.DataResponse;
import ru.privetapp.server.interview.messages.ListResponse;
import ru.privetapp.server.interview.messages.LoginResponse;

@RestController
@RequestMapping("/")
public class MainServiceController {

	@Autowired private IMainService personService;

	@RequestMapping("/login")
	public DataResponse<LoginResponse> login(@RequestParam(value = "email", required = true) String email, @RequestParam(value = "password", required = true) String password) throws InterviewServiceException {
		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setSessionId(personService.login(email, password));
		return new DataResponse<LoginResponse>(loginResponse);
	}

	@RequestMapping("/list")
	public DataResponse<ListResponse> list(@RequestParam(value = "session", required = true) String sessionId, @RequestParam(value = "offset", required = false) Integer offset, @RequestParam(value = "count", required = false) Integer count) throws InterviewServiceException {
		ListResponse listResponse = new ListResponse();
		listResponse.setItems(personService.list(sessionId, offset, count));
		return new DataResponse<ListResponse>(listResponse);
	}
}