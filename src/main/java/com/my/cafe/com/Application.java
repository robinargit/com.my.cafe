package com.my.cafe.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    private static final Logger LOGGER = LogManager.getLogger(Application.class);

	public static void main(String[] args) {

	   // SpringApplication.run(Application.class, args);

        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        LOGGER.info("Info level log message");
        LOGGER.debug("Debug level log message");
        LOGGER.error("Error level log message");


        LOGGER.info("Spring Boot Application Started");


	}

}



