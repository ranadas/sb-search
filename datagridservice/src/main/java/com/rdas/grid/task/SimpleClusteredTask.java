package com.rdas.grid.task;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.Serializable;
import java.util.UUID;

//https://dzone.com/articles/distributed-scheduling-and-servicing-in-java
@Slf4j
public class SimpleClusteredTask implements ClusteredTask, Runnable, Serializable {
    private transient LocalResource localResource;

    private final UUID id = UUID.randomUUID();

    @Override
    public void setLocalResource(LocalResource localResource) {
        this.localResource = localResource;
    }

    @Override
    public void run() {
        log.info("Execute simple task, id: {}, thread:[{}]", id, Thread.currentThread().getName());
        try {
            localResource.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}