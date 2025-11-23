package com.tarequlrobin.bookmark_api;

import org.springframework.boot.SpringApplication;

public class TestBookmarkApiApplication {

	public static void main(String[] args) {
		SpringApplication.from(BookmarkApiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
