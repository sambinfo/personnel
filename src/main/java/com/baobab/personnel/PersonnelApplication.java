package com.baobab.personnel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PersonnelApplication implements CommandLineRunner{
    Logger logger = LoggerFactory.getLogger(com.baobab.personnel.PersonnelApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PersonnelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.logger.info("### --- --- - CommandLineRunner : ");
	}

}
