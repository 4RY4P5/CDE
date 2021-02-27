package com.cognizant.menuItemService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@SpringBootApplication
@EnableDiscoveryClient
public class MenuItemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MenuItemServiceApplication.class, args);
	}

}