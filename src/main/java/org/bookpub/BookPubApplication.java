package org.bookpub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookPubApplication {

	public static void main(String[] args) {

		SpringApplication.run(BookPubApplication.class, args);
	}

	@Bean
	public StartupRunner getStartupRunner(){
		return new StartupRunner();
	}
}
