package com.initgrep.apps.nauth;

import com.initgrep.apps.nauth.services.CommandProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NauthApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(NauthApplication.class, args);
	}

	@Autowired
	CommandProcessor processor;
	@Override
	public void run(String... args) throws Exception {

		processor.processCommand();
		processor.processCommand();
		processor.processCommand();
		processor.processCommand();

	}
}
