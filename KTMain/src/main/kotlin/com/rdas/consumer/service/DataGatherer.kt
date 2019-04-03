package com.rdas.consumer.service

import com.rdas.blogpostsmodel.BlogPostBase
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.async
//import kotlinx.coroutines.CommonPool
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit
import javax.annotation.PostConstruct


@Service
class DataGatherer(val templateBuilder: RestTemplateBuilder,
                   @Value("\${remoteserver.host}") val host: String,
                   @Value("\${remoteserver.port}") val port: Int,
                   @Value("\${remoteserver.context}") val serverContext: String,
                   @Value("\${remoteserver.getUrl}") val getUrl: String) {

    val restTemplate = templateBuilder.rootUri("http://$host:$port/$serverContext").build()

    @PostConstruct
    fun init(): Unit {

        println("Constructing rest template with host $host and port $port")

    }

    /**
    ResponseEntity<BlogPostBase> response = restTemplate.exchange(
    endpointGetURL,
    HttpMethod.GET,
    entity,
    BlogPostBase.class);
    return response.getBody();
     */
    /*
    fun getBlogPostMessages(): List<BlogPostBase> {

        fun asyncGetForObject(id: Int) = async(CommonPool) {
            TimeUnit.SECONDS.sleep(4)
            restTemplate.getForObject("/messages/$id/", BlogPostBase::class.java)
        }

        val messages = listOf(asyncGetForObject(1), asyncGetForObject(2))

        return runBlocking { messages.map { it.await() } }

    }

    fun asyncGetForObject(id: Int) = async(CommonPool) {
        TimeUnit.SECONDS.sleep(4)
        restTemplate.getForObject("/messages/$id/", BlogPostBase::class.java)
    }
    */
}