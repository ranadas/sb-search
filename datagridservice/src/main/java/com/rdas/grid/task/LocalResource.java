package com.rdas.grid.task;

import com.rdas.grid.service.BlogServiceClient;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.UUID;

@Slf4j
public class LocalResource {
    private final UUID instanceId = UUID.randomUUID();
    private final BlogServiceClient blogServiceClient;

    public LocalResource(BlogServiceClient client) {
        blogServiceClient=client;
        log.info("Creating local resource. UUID:[{}]", instanceId);
    }

    public void execute() throws IOException {
        log.info("Executing local resource. UUID:[{}]", instanceId);
        //log.info(blogServiceClient.getBlog().toString());
        //TODO : add this to
    }
}
