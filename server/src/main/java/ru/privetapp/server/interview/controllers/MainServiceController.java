package ru.privetapp.server.interview.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.privetapp.server.interview.component.IMainService;

@RestController
@RequestMapping("/main")
public class MainServiceController {

	@Autowired private IMainService personService;

	@RequestMapping("/login")
	public UUID login(@RequestParam(value = "email", required = true) String email, @RequestParam(value = "password", required = true) String password) {
		return personService.login(email, password);
	}

}
