package com.example.backendandapi;

import com.example.backendandapi.models.request.bodies.CreateAccountReqBody;
import com.example.backendandapi.models.request.bodies.EditAccountReqBody;
import com.example.backendandapi.models.request.bodies.GetAccountReqBody;
import com.example.backendandapi.models.request.bodies.LoginReqBody;
import com.example.backendandapi.models.user.User;
import com.example.backendandapi.services.database.UserDbService;
import com.example.backendandapi.services.request.validators.CreateAccountValidator;
import com.example.backendandapi.services.request.validators.EditAccountValidator;
import com.example.backendandapi.services.request.validators.GetAccountValidator;
import com.example.backendandapi.services.request.validators.LoginValidator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendAndApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendAndApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(EditAccountValidator validator) {
		return (args) -> {
			System.out.println(validator.isValidRequest(new EditAccountReqBody("varli", "about me", "url", "pass123#", "pass123#")));
			System.out.println(validator.isValidRequest(new EditAccountReqBody("varli", "about me", "url", "pass123#", "pass1")));
			System.out.println(validator.isValidRequest(new EditAccountReqBody("varli", "about me", "url", "pass123#", "12345#")));
			System.out.println(validator.isValidRequest(new EditAccountReqBody("varli", "about me", "url", "pass123#", "######")));
			System.out.println(validator.isValidRequest(new EditAccountReqBody("varli", "about me", "url", "pass123#", "passabc")));
			System.out.println(validator.isValidRequest(new EditAccountReqBody("varli", "about me", "url", "pass123#", "123456")));
			System.out.println(validator.isValidRequest(new EditAccountReqBody("varli", "about me", "url", "pass123#", "pass#!$")));
		};
	}
}
