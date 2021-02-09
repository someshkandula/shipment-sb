package com.somesh.airship.dto;

import java.io.Serializable;

/**
 * @author ksomalin
 *
 */
public class Meta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private float code;

	// Getter Methods

	public float getCode() {
		return code;
	}

	// Setter Methods

	public void setCode(float code) {
		this.code = code;
	}
}