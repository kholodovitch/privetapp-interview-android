package ru.privetapp.server.interview.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import ru.privetapp.server.interview.types.ResponseStatus;

public class BaseResponse {
	private ResponseStatus status;
	@JsonInclude(Include.NON_NULL) private String description;

	public BaseResponse() {
		status = ResponseStatus.ok;
	}

	public ResponseStatus getStatus() {
		return status;
	}

	public void setStatus(ResponseStatus status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
