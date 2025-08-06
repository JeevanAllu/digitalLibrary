package com.example.digitalLibraryPractice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
@Slf4j
public class DigitalLibraryPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalLibraryPracticeApplication.class, args);
	}

}
