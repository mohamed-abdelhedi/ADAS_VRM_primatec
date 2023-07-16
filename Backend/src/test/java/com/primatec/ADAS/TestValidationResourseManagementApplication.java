package com.primatec.ADAS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestValidationResourseManagementApplication {

	public static void main(String[] args) {
		SpringApplication.from(ValidationResourseManagementApplication::main).with(TestValidationResourseManagementApplication.class).run(args);
	}

}
