package com.somesh.airship.dto;

import java.io.Serializable;

/**
 * @author ksomalin
 *
 */
public class ErrorDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	String statusCode;
	String description;

	public ErrorDetails(String statusCode, String description) {
		super();
		this.statusCode = statusCode;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
