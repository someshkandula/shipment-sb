package com.somesh.airship.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.somesh.airship.dto.AirShipResponse;
import com.somesh.airship.dto.Shipment;
import com.somesh.airship.dto.TrackingResponse;

/**
 * @author ksomalin
 *
 */
@Service
public interface ShipmentService {

	public ResponseEntity<AirShipResponse<TrackingResponse>> createShipment(Shipment shipment);

	public ResponseEntity<AirShipResponse<TrackingResponse>> getShipment(String slug, String trackingNumber);
}