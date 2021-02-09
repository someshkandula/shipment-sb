package com.somesh.airship.constant;

import org.springframework.stereotype.Component;

@Component
public class Constants {

	// URL's
	public final static String PING_URI = "/ping";
	public final static String CREATE_TRACKING_URI = "/trackings";
	public final static String GET_TRACKING_URI = "/trackings/{slug}/{trackingNumber}";
	public final static String TRACKING_API = "https://api.aftership.com/v4/trackings";

	// Constants
	public final static String SUCCESS = "SUCCESS";
	public final static String FAILURE = "FAILURE";
	public final static String BACKSLASH = "/";
	public final static String YOUR_API_KEY = "aftership-api-key";
	public final static String YOUR_API_VALUE = "NEED TO GENERATE THE KEY AN ADD HERE";
	public static final String DUPLICATEMSG = "Tracking already exists.";
}
