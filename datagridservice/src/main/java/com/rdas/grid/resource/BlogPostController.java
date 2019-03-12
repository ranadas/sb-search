package com.rdas.grid.resource;

import com.rdas.blogpostsmodel.BlogPostBase;
import com.rdas.grid.service.BlogServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
public class BlogPostController {

    private final BlogServiceClient blogServiceClient;

    @Autowired
    public BlogPostController(BlogServiceClient blogServiceClient) {
        this.blogServiceClient = blogServiceClient;
    }

    @GetMapping("/showRand")
    public BlogPostBase getBlog() throws IOException {
        return blogServiceClient.getBlogData();
    }
}
