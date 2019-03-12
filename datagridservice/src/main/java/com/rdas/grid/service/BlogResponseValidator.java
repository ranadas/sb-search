package com.rdas.grid.service;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ITopic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BlogResponseValidator {

    private final HazelcastInstance gridHzInstance;
    private ITopic messageQueueTopic;

    public BlogResponseValidator(@Qualifier("gridHzInstance") HazelcastInstance hazelcastInstance,
                                 @Value("${messagequeue.topic.name}") String messageQueueTopicName) {
        gridHzInstance = hazelcastInstance;
        log.info("Creating BlogResponseValidator");
        messageQueueTopic = gridHzInstance.getTopic( messageQueueTopicName );

        messageQueueTopic.addMessageListener(msg -> {
            log.info("Blog Received: {}", msg.getMessageObject());
        });

        log.info("Starting Message Queue Topic");
    }
}
