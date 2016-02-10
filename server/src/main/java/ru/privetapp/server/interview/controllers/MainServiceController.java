package ru.privetapp.server.interview.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.privetapp.server.interview.component.IMainService;
import ru.privetapp.server.interview.messages.DataResponse;
import ru.privetapp.server.interview.messages.LoginResponse;

@RestController
@RequestMapping("/main")
public class MainServiceController {

	@Autowired private IMainService personService;

	@RequestMapping("/login")
	public DataResponse<LoginResponse> login(@RequestParam(value = "email", required = true) String email, @RequestParam(value = "password", required = true) String password) {
		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setSessionId(personService.login(email, password));
		return new DataResponse<LoginResponse>(loginResponse);
	}

}