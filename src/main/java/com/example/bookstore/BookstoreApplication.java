package com.example.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import com.example.bookstore.model.Role;

import jakarta.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@EntityScan(basePackageClasses = { 
	BookstoreApplication.class,
	Role.class,
	Jsr310JpaConverters.class 
})
public class BookstoreApplication {
	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

}
