package com.akturkpasaj.User.Management.System;

import com.akturkpasaj.User.Management.System.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class UserManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagementSystemApplication.class, args);
	}

}
