package com.somesh.airship.dto;

import java.io.Serializable;

/**
 * @author ksomalin
 *
 */
public class Data implements Serializable {

	private static final long serialVersionUID = 1L;
	Tracking TrackingObject;

	// Getter Methods

	public Tracking getTracking() {
		return TrackingObject;
	}

	// Setter Methods

	public void setTracking(Tracking trackingObject) {
		this.TrackingObject = trackingObject;
	}
}
