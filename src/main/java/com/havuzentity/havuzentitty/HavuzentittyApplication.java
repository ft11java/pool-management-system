package com.havuzentity.havuzentitty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//  exclude=SecurityAutoConfiguration.class   ---> Spring sercurity pasif yapmak için
@SpringBootApplication//(exclude=SecurityAutoConfiguration.class)
public class HavuzentittyApplication {

	public static void main(String[] args) {
		SpringApplication.run(HavuzentittyApplication.class, args);
	}

}
