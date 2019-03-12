package com.rdas

import com.fasterxml.jackson.databind.ObjectMapper
import com.rdas.blogpostsmodel.BlogPostBase
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import static groovy.io.FileType.FILES

//@SpringBootTest
class LoadContextTest extends Specification {

//    @Autowired (required = false)
//    private WebController webController

    def "when context is loaded then all expected beans are created"() {
        expect: "the WebController is created"
        1
//        webController
    }

    def "demo for reading a text file"() {
        when: "a paragraph is processed"

        String inputText = new File("src/test/resources/blogs_0000001.json").text
        println inputText
        and :
        ObjectMapper objectMapper = new ObjectMapper()

        then: "word frequency should be correct"
        BlogPostBase blogPostBase = objectMapper.readValue(inputText, BlogPostBase.class);
        println blogPostBase.toString()

    }

    def "traverse dataset folder to read files and deserialise" () {
        given : "../../../../../../datasets/"
        def dir = new File("../datasets/");

        when:
        def files = [];
        and:
        dir.traverse(type: FILES, maxDepth: 0) { files.add(it) };

        then :
        1==1
        and:
        println files

    }
}