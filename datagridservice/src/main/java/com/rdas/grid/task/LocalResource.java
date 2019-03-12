package com.rdas.grid.task;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ITopic;
import com.rdas.grid.service.BlogServiceClient;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.UUID;

@Slf4j
public class LocalResource {
    private final UUID instanceId = UUID.randomUUID();
    private final BlogServiceClient blogServiceClient;
    private final HazelcastInstance gridHzInstance;
    private ITopic blogPostTopic;

    private final String topicName;

    public LocalResource(BlogServiceClient client, HazelcastInstance hazelcastInstance, String topic) {
        blogServiceClient = client;
        gridHzInstance = hazelcastInstance;
        log.info("Creating local resource. UUID:[{}]", instanceId);
        topicName = topic;
        blogPostTopic = gridHzInstance.getTopic(topicName);
    }

    public void execute() throws IOException {
        log.info("Executing local resource. UUID:[{}]", instanceId);

        blogPostTopic.publish(blogServiceClient.getBlogData());
    }
}
