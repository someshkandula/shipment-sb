package com.somesh.airship.dto;

import java.io.Serializable;

/**
 * @author ksomalin
 *
 */
public class CreateShipment implements Serializable {

	private static final long serialVersionUID = 1L;
	private Shipment tracking;

	public CreateShipment(Shipment tracking) {
		super();
		this.tracking = tracking;
	}

	public Shipment getTracking() {
		return tracking;
	}

	public void setTracking(Shipment tracking) {
		this.tracking = tracking;
	}

	@Override
	public String toString() {
		return "{tracking=" + tracking + "}";
	}

}
