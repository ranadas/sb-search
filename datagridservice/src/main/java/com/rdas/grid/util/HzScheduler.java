package com.rdas.grid.util;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.scheduledexecutor.IScheduledExecutorService;
import com.hazelcast.scheduledexecutor.IScheduledFuture;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static com.hazelcast.scheduledexecutor.impl.NamedTaskDecorator.named;
//https://stackoverflow.com/questions/49274273/running-a-cron-job-on-hazelcast-durableexecutorservice/49274504
//https://octoperf.com/blog/2018/06/12/spring-boot-hazelcast-tutorial/
//https://github.com/javanotes/ticker/blob/master/src/main/java/org/reactivetechnologies/ticker/scheduler/DistributedScheduledTask.java
public class HzScheduler {

    @PostConstruct
    public void init() throws ExecutionException, InterruptedException {
        HazelcastInstance instance = Hazelcast.newHazelcastInstance();

        IScheduledExecutorService scheduler = instance.getScheduledExecutorService("scheduler");
        IScheduledFuture<String> future = scheduler.schedule(named("MyTask", new EchoTask("foobar")), 5, TimeUnit.SECONDS);

        Object result = future.get();
        System.out.println(future.getHandler().getTaskName() + " result: " + result);

        future.dispose();

        //Hazelcast.shutdownAll();
    }
//https://github.com/hazelcast/hazelcast-code-samples/blob/master/distributed-executor/scheduling-named-task/src/main/java/MasterMember.java
    public class EchoTask implements Callable<String>, Serializable {

        private final String msg;

        public EchoTask(String msg) {
            this.msg = msg;
        }

        @Override
        public String call() throws Exception {
            return msg;
        }
    }
}
