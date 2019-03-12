package com.rdas.datasets.resource;

import com.rdas.blogpostsmodel.BlogPostBase;
import com.rdas.datasets.util.JsonSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class JsonDataController {

    @Autowired
    private JsonSupplier jsonSupplier;

    //curl localhost:8081/dataservice/showRand
    @GetMapping("/showRand")
    public BlogPostBase getBlog() throws IOException {
        return jsonSupplier.getRandomBlogPost();
    }

    //curl -X POST localhost:8081/dataservice/ackn?status=FALSE
    //curl -X POST localhost:8081/dataservice/ackn?status=TRUE
    @PostMapping("/ackn")
    public ResponseEntity<?> receiveAcknowledgement(@RequestParam Boolean status) {
        return new ResponseEntity<>(String.format("%s  - Acknowledgement Accepted", status), HttpStatus.ACCEPTED);
    }
}
