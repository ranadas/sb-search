package com.rdas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataServerApplication {
    private static final Logger log = LoggerFactory.getLogger(DataServerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DataServerApplication.class);
    }
}
