package com.rdas.grid.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rdas.blogpostsmodel.BlogPostBase;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Component
public class JsonSupplier {
    @Getter
    private List<Path> fileList;

    @Autowired
    private ObjectMapper gridJsonMapper;

    @PostConstruct
    public void init() throws IOException {
        fileList = Collections.synchronizedList(new ArrayList());
        Files.newDirectoryStream(Paths.get("datasets/"),
                path -> path.toString().endsWith(".json"))
                .forEach(f -> fileList.add(f.toAbsolutePath()));
    }

    public BlogPostBase getRandomBlogPost() throws IOException {
        int upper = fileList.size();
        Random rand = new Random();
        int value = rand.nextInt(upper);
        Path path = fileList.get(value);
        try (InputStream fileStream = new FileInputStream(path.toFile())) {
            BlogPostBase blogPostBase = gridJsonMapper.readValue(fileStream, BlogPostBase.class);
            return blogPostBase;
        }
    }
}
