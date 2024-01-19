package com.swajan.bharat.nits.ramjas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RamjasApplication {

	public static void main(String[] args) {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		SpringApplication.run(RamjasApplication.class, args);
	}

}
