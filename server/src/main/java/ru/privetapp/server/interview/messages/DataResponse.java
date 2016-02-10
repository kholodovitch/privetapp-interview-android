package ru.privetapp.server.interview.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import ru.privetapp.server.interview.types.ResponseStatus;

public class DataResponse<T extends IResponseData> {
	private ResponseStatus status;
	@JsonInclude(Include.NON_NULL) private String description;
	private T data;

	public DataResponse() {
		status = ResponseStatus.ok;
	}

	public DataResponse(T data) {
		this();
		this.data = data; 
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

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
