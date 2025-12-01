package com.tarequlrobin.bookmarker_api;

import org.springframework.boot.SpringApplication;

public class TestBookmarkApiApplication {

	public static void main(String[] args) {
		SpringApplication.from(BookmarkerApiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
