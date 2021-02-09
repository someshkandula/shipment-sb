package com.somesh.airship.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.somesh.airship.constant.Constants;
import com.somesh.airship.dto.AirShipResponse;
import com.somesh.airship.dto.CreateShipment;
import com.somesh.airship.dto.Response;
import com.somesh.airship.dto.Shipment;
import com.somesh.airship.dto.TrackingResponse;
import com.somesh.airship.utils.Utils;

@Service
public class ShipmentServiceImpl implements ShipmentService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ShipmentServiceImpl.class);

	@Autowired
	Utils utils;

	/**
	 * createShipment api is used to create the new shipment details return : 201
	 * Created
	 */
	public ResponseEntity<AirShipResponse<TrackingResponse>> createShipment(Shipment shipment) {

		LOGGER.info("createShipmentDetails api started");

		HttpHeaders headers = utils.getHeader();

		String request = utils.objToJson(new CreateShipment(shipment));

		LOGGER.info("createShipmentDetails api request : {} ", request);

		HttpEntity<String> entity = new HttpEntity<String>(request, headers);

		@SuppressWarnings("unchecked")
		ResponseEntity<Response> response = (ResponseEntity<Response>) utils.consumeWebService(Constants.TRACKING_API,
				HttpMethod.POST, entity, Response.class);

		LOGGER.info("Post createShipmentDetails api response : {} ", response);

		return populateAirShipResponse(response);
	}

	/**
	 * @param slug
	 * @param trackingNumber
	 * @return getShipment will return shipment details along with status, if
	 *         doesn't exist "tracking not found".
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<AirShipResponse<TrackingResponse>> getShipment(String slug, String trackingNumber) {

		LOGGER.info("Service to generate URL and call airship getShipmentDetails api");

		HttpHeaders headers = utils.getHeader();

		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<Response> response = (ResponseEntity<Response>) utils
				.consumeWebService(generateURL(slug, trackingNumber), HttpMethod.GET, entity, Response.class);

		LOGGER.info("Post getShipmentDetails api response : {} ", response);

		return populateAirShipResponse(response);

	}

	/**
	 * @param slug
	 * @param shipmentId
	 * @return Build URI based on the Input Parameters
	 */
	private String generateURL(String slug, String shipmentId) {

		StringBuilder strBuilder = new StringBuilder(Constants.TRACKING_API);
		strBuilder.append(Constants.BACKSLASH);
		strBuilder.append(slug);
		strBuilder.append(Constants.BACKSLASH);
		strBuilder.append(shipmentId);
		LOGGER.info("Get shipment API : {} ", strBuilder.toString());
		return strBuilder.toString();
	}

	/**
	 * @param response
	 * @return ResponseEntity<AirShipResponse<TrackingResponse>> Get Tracking
	 *         Response for Shipment ID and Slug
	 */
	private ResponseEntity<AirShipResponse<TrackingResponse>> populateAirShipResponse(
			ResponseEntity<Response> response) {

		LOGGER.info("Populating airship response, statuscode : {} ", response.getStatusCode());
		AirShipResponse<TrackingResponse> asResponse = new AirShipResponse<TrackingResponse>();
		TrackingResponse trackingResponse = new TrackingResponse();
		asResponse.setDescription("Tracking " + String.valueOf(response.getStatusCode().getReasonPhrase()));
		if (response.getStatusCode() == HttpStatus.OK || response.getStatusCode() == HttpStatus.CREATED) {
			trackingResponse.setId(response.getBody().getData().getTracking().getId());
			trackingResponse.setTrackingNumber(response.getBody().getData().getTracking().getTracking_number());
			trackingResponse.setOrigin(response.getBody().getData().getTracking().getOrigin_country_iso3());
			trackingResponse.setDestination(response.getBody().getData().getTracking().getDestination_country_iso3());
			trackingResponse.setCourierCode(response.getBody().getData().getTracking().getSlug());
			trackingResponse.setCurrentStatus(response.getBody().getData().getTracking().getTag());
			asResponse.setData(trackingResponse);
		} else if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
			asResponse.setDescription(Constants.DUPLICATEMSG);
		}

		asResponse.setStatusCode(String.valueOf(response.getStatusCodeValue()));
		return new ResponseEntity<AirShipResponse<TrackingResponse>>(asResponse, response.getStatusCode());
	}
}