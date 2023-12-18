package org.zerock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class MaillogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaillogApplication.class, args);
		
	}
}
