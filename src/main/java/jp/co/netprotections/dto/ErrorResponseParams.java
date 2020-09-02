package jp.co.netprotections.dto;

import java.util.List;

public class ErrorResponseParams {
	private String message;
	private List<String> details;

	public ErrorResponseParams(String message, List<String> details) {
		this.message = message;
		this.details = details;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<String> getDetails() {
		return details;
	}
	public void setDetails(List<String> details) {
		this.details = details;
	}

}
