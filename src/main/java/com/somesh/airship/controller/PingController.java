package com.somesh.airship.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.somesh.airship.constant.Constants;

@Controller
public class PingController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PingController.class);

	@GetMapping(value = Constants.PING_URI)
	@ResponseBody
	public String ping() {
		LOGGER.info(" Ping Controller to Check the heath status ");
		return Constants.SUCCESS;
	}
}