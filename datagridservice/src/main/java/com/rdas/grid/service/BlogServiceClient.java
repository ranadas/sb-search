package com.rdas.grid.service;

import com.rdas.blogpostsmodel.BlogPostBase;
import com.rdas.grid.util.JsonSupplier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

//https://www.baeldung.com/restclienttest-in-spring-boot
@Slf4j
@Service
public class BlogServiceClient {

    private final RestTemplate restTemplate;
    private final JsonSupplier jsonSupplier;
    private final String endpointGetURL;
    private final String endpointPostURL;

    public BlogServiceClient(RestTemplateBuilder restTemplateBuilder, JsonSupplier supplier,
                             @Value("${endpoint.geturl}") String endpointGetURL,
                             @Value("${endpoint.posturl}") String endpointPostURL) {
        restTemplate = restTemplateBuilder.build();
        jsonSupplier = supplier;
        this.endpointGetURL = endpointGetURL;
        this.endpointPostURL = endpointPostURL;
    }

    public BlogPostBase getBlogData() throws IOException {
        //TODO : use the rest client to get the blog instead of json supplier
        //return jsonSupplier.getRandomBlogPost();
        //String formatted_URL = MessageFormat.format(uri, value1, value2);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<BlogPostBase> response = restTemplate.exchange(
                    endpointGetURL,
                    HttpMethod.GET,
                    entity,
                    BlogPostBase.class);
            return response.getBody();
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public Boolean sendAcknowledgement() {
        // TODO POST to  endpointPostURL
        return true;
    }
}
