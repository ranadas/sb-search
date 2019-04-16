package com.rdas.grid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class CloudConfigApplication {
    private static final Logger log = LoggerFactory.getLogger(CloudConfigApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigApplication.class);
    }
}
