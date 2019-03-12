package com.rdas.grid.service;

import com.hazelcast.config.Config;
import com.hazelcast.config.ScheduledExecutorConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.scheduledexecutor.IScheduledExecutorService;
import com.rdas.grid.task.LocalResource;
import com.rdas.grid.task.SimpleClusteredTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class DistributedScheduler {

    private final HazelcastInstance gridHzInstance;
    private IScheduledExecutorService scheduledExecutorService;
    private final String schedulerName;
    private final BlogServiceClient blogServiceClient;
    private final Long schedulerPeriod;
    private final String messageQueueTopicName;

    @Autowired
    public DistributedScheduler(@Value("${scheduler.rate}") Long schedulerPeriod,
                                @Value("${scheduler.name}") String schedulerName,
                                @Value("${messagequeue.topic.name}") String messageQueueTopicName,
                                @Qualifier("gridHzInstance") HazelcastInstance hazelcastInstance,
                                BlogServiceClient client) {
        this.schedulerPeriod = schedulerPeriod;
        this.gridHzInstance = hazelcastInstance;
        this.schedulerName = schedulerName;
        this.blogServiceClient = client;
        this.messageQueueTopicName = messageQueueTopicName;
    }

    @PostConstruct
    public void init() {
        scheduledExecutorService = gridHzInstance.getScheduledExecutorService(schedulerName);

        SimpleClusteredTask task = new SimpleClusteredTask();
        LocalResource localResource = new LocalResource(blogServiceClient, gridHzInstance, messageQueueTopicName);
        task.setLocalResource(localResource);

        scheduledExecutorService.scheduleAtFixedRate(task, 0, schedulerPeriod, TimeUnit.SECONDS);
    }


    //http://useof.org/java-open-source/com.hazelcast.config.ScheduledExecutorConfigÓ
    //https://github.com/hazelcast/hazelcast/blob/master/hazelcast/src/test/java/com/hazelcast/scheduledexecutor/ScheduledExecutorServiceTestSupport.java
    public void init1() {
        ScheduledExecutorConfig sec = new ScheduledExecutorConfig()
                .setName(schedulerName)
                .setDurability(1)
                .setPoolSize(1).
                        setCapacity(0);
        Config config = new Config().addScheduledExecutorConfig(sec);
        //HazelcastInstance[] instances = createClusterWithCount(1, config);
        scheduledExecutorService = gridHzInstance.getScheduledExecutorService(schedulerName);
        String keyOwner = "hitSamePartitionToCheckCapacity";
    }
}
