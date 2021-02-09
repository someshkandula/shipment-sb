package com.somesh.airship.utils;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.somesh.airship.constant.Constants;

@Component
public class Utils {

	@Autowired
	RestTemplate restTemplate;

	private static final Logger LOGGER = LoggerFactory.getLogger(Utils.class);

	@Autowired
	private ObjectMapper objectMapper;

	/**
	 * @param obj
	 * @return
	 * Object to JSON
	 */
	public String objToJson(Object obj) {
		String objJackson = null;
		try {
			objJackson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			LOGGER.error("failed conversion: Pfra object to Json", e);
		}
		return objJackson;
	}

	/**
	 * @return
	 * Build Header for Restful call.
	 */
	public HttpHeaders getHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set(Constants.YOUR_API_KEY, Constants.YOUR_API_VALUE);
		return headers;
	}

	/**
	 * @param <T>
	 * @param url
	 * @param method
	 * @param responseType
	 * @return ResponseEntity Generic Web Service call, return ResponseEntity
	 * 
	 */
	public <T> ResponseEntity<?> consumeWebService(String url, HttpMethod method, HttpEntity<?> entity,
			Class<T> responseType) {
		try {
			LOGGER.info("Invoke external api URL: {} , method: {} ", url, method);
			return restTemplate.exchange(url, method, entity, responseType);
		} catch (RestClientResponseException e) {
			LOGGER.error("Exception occured during external api msg: {} , statuscode: {} ", e.getMessage(),
					e.getRawStatusCode());
			return ResponseEntity.status(e.getRawStatusCode()).body(e.getResponseBodyAsString());
		}
	}
}
