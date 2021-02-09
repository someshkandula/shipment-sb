package com.somesh.airship.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.somesh.airship.constant.Constants;
import com.somesh.airship.dto.AirShipResponse;
import com.somesh.airship.dto.Shipment;
import com.somesh.airship.dto.TrackingResponse;
import com.somesh.airship.service.ShipmentService;
import com.somesh.airship.utils.CourierCode;
import com.somesh.airship.utils.EnumAnnotation;

@RestController
@Validated
public class ShipmentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ShipmentController.class);

	@Autowired
	ShipmentService shipmentService;

	/**
	 * @param shipment - Input parameter for createShipment contains trackingnumber, slug, origin and destination
	 * @return ResponseEntity<AirShipResponse<TrackingResponse>> createShipment API is used to create new shipment / Trackings
	 */
	@PostMapping(value = Constants.CREATE_TRACKING_URI, produces = {
			MediaType.APPLICATION_JSON_VALUE }, headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<AirShipResponse<TrackingResponse>> createShipment(@Valid @RequestBody Shipment shipment) {
		LOGGER.info("Create shipment details : {}  ", shipment);
		return shipmentService.createShipment(shipment);
	}
	
	

	/**
	 * @param slug - Courier code
	 * @param trackingNumber - Tracking number is to track the shipment
	 * @return ResponseEntity<AirShipResponse<TrackingResponse>> getShipment API is
	 *         used to get Tracking details
	 */
	@GetMapping(value = Constants.GET_TRACKING_URI)
	@ResponseBody
	public ResponseEntity<AirShipResponse<TrackingResponse>> getShipment(
			@PathVariable @Valid @NonNull @NotEmpty @EnumAnnotation(enumClass = CourierCode.class, ignoreCase = true) String slug,
			@PathVariable @Valid @NonNull @NotEmpty @Size(min = 12) String trackingNumber) {

		LOGGER.info("Get shipment details for slug: {}  trackingNumber: {}", slug, trackingNumber);
		return shipmentService.getShipment(slug, trackingNumber);
	}

}