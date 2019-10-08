package com.transfertArg.transfertArg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
@SpringBootApplication
public class TransfertArgApplication extends ServletInitializer  {

	public static void main(String[] args) {
		SpringApplication.run(TransfertArgApplication.class, args);
	}
	//@Autowired
	//PasswordEncoder encoder;
	//@Override
	//public void run(String... args) throws Exception{
	//	System.out.println(encoder.encode("passer"));
	//}
}
