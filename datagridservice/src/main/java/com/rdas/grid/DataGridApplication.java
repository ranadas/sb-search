package com.rdas.grid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataGridApplication {
    private static final Logger log = LoggerFactory.getLogger(DataGridApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DataGridApplication.class);
    }
}
