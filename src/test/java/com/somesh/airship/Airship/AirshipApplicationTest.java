package com.somesh.airship.Airship;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.somesh.airship.Application;

@SpringBootTest
public class AirshipApplicationTest {
	
	@Autowired
	Application application;
	
	@Disabled
	@Test
	void test_airship_applicaton() {
		
	}

}
