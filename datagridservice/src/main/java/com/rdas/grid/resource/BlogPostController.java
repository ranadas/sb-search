package com.rdas.grid.resource;

import com.rdas.blogpostsmodel.BlogPostBase;
import com.rdas.grid.util.JsonSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class BlogPostController {

    @Autowired
    private JsonSupplier jsonSupplier;

    @GetMapping("/showRand")
    public BlogPostBase getBlog() throws IOException {
        return jsonSupplier.getRandomBlogPost();
    }
}
