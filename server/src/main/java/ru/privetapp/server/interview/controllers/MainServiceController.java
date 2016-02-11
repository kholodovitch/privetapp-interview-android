package ru.privetapp.server.interview.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.privetapp.server.interview.component.IMainService;
import ru.privetapp.server.interview.exceptions.InterviewServiceException;
import ru.privetapp.server.interview.messages.DataResponse;
import ru.privetapp.server.interview.messages.IResponseData;
import ru.privetapp.server.interview.messages.ListResponse;
import ru.privetapp.server.interview.messages.LoginResponse;
import ru.privetapp.server.interview.types.ResponseStatus;

@RestController
@RequestMapping("/")
public class MainServiceController {

	@Autowired private IMainService personService;

	@RequestMapping("/login")
	public DataResponse<LoginResponse> login(@RequestParam String email, @RequestParam String password) throws InterviewServiceException {
		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setSessionId(personService.login(email, password));
		return new DataResponse<LoginResponse>(loginResponse);
	}

	@RequestMapping("/list")
	public DataResponse<ListResponse> list(@RequestParam String sessionId, @RequestParam(required = false) Integer offset, @RequestParam(required = false) Integer count) throws InterviewServiceException {
		ListResponse listResponse = new ListResponse();
		listResponse.setItems(personService.list(sessionId, offset, count));
		return new DataResponse<ListResponse>(listResponse);
	}

	@ExceptionHandler(InterviewServiceException.class)
	public ResponseEntity<DataResponse<IResponseData>> rulesForCustomerNotFound(HttpServletRequest req, InterviewServiceException e) {
		DataResponse<IResponseData> error = new DataResponse<IResponseData>();
		error.setStatus(ResponseStatus.error);
		error.setDescription(e.getMessage());
		return new ResponseEntity<DataResponse<IResponseData>>(error, HttpStatus.NOT_FOUND);
	}
}