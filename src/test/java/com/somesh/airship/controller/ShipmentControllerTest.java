package com.somesh.airship.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import javax.validation.ConstraintViolationException;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.somesh.airship.dto.AirShipResponse;
import com.somesh.airship.dto.Shipment;
import com.somesh.airship.dto.TrackingResponse;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ShipmentControllerTest {

	@Autowired
	ShipmentController shipmentController;

	// Valid Tracking Number
	@Test
	void testGetTrackings_Valid_Tracking_Number() {
		ResponseEntity<AirShipResponse<TrackingResponse>> response = shipmentController.getShipment("USPS",
				"9400111202555386596177");
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("9400111202555386596177", response.getBody().getData().getTrackingNumber());
	}

	// InValid Tracking Number
	@Test
	void testGetTrackings_InValid_Tracking_Number() {
		ResponseEntity<AirShipResponse<TrackingResponse>> response = shipmentController.getShipment("USPS",
				"94001112025553865969876");
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		assertEquals("Tracking Not Found", response.getBody().getDescription());
	}

	// ConstraintViolationException - Validation
	@Test
	void testGetTrackings_NotAllowed_Tracking_Number() {

		Assertions.assertThrows(ConstraintViolationException.class, () -> {
			shipmentController.getShipment("USPS", "1234");
		});
	}

	// ConstraintViolationException - Validation
	@Test
	void testGetTrackings_NotAllowed_slug() {
		Assertions.assertThrows(ConstraintViolationException.class, () -> {
			shipmentController.getShipment("ABC", "94001112025553865969876");
		});
	}

	// Create Shipment API testing
	@Test
	void testCreateShipment() {

		Random random = new Random();
		String generate4DigitPin = String.format("%04d",  random.nextInt(10000000) % 10000);
		String trackingNumber = "123456789" + generate4DigitPin;
		System.out.println("trackingNumber"+trackingNumber);
		Shipment shipment = new Shipment();
		shipment.setSlug("fedex");
		shipment.setTracking_number(trackingNumber);
		shipment.setOrigin_country_iso3("USA");
		shipment.setDestination_country_iso3("IND");
		ResponseEntity<AirShipResponse<TrackingResponse>> response = shipmentController.createShipment(shipment);
		Assert.assertNotNull(response);
		assertEquals(trackingNumber, response.getBody().getData().getTrackingNumber());
	}

	// createShipment.shipment.slug: Invalid value. This is not permitted
	@Test
	void testCreateShipment_InvalidSlug_InPostAPI() {
		Assertions.assertThrows(ConstraintViolationException.class, () -> {
			Shipment shipment = new Shipment();
			shipment.setSlug("fed");
			shipment.setTracking_number("123456754321");
			shipment.setOrigin_country_iso3("USA");
			shipment.setDestination_country_iso3("IND");
			shipmentController.createShipment(shipment);
		});
	}

	// createShipment.shipment.slug: Invalid value. This is not permitted
	@Test
	void testCreateShipment_InvalidTrackingNumberInPostAPI() {
		Assertions.assertThrows(ConstraintViolationException.class, () -> {
			Shipment shipment = new Shipment("12345", "USA", "IND", "fedex");
			shipmentController.createShipment(shipment);
		});
	}
}
