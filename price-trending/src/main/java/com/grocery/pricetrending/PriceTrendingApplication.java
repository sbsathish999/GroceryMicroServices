package com.grocery.pricetrending;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PriceTrendingApplication {

	public static void main(String[] args) {
		SpringApplication.run(PriceTrendingApplication.class, args);
	}

}
