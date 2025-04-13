package com.paulpladziewicz.contactservice;

import org.springframework.boot.SpringApplication;

public class TestContactserviceApplication {

	public static void main(String[] args) {
		SpringApplication.from(ContactserviceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
