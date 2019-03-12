package com.rdas.blogpostsmodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class BlogPostBase implements Serializable {
    @JsonProperty("organizations")
    private Object[] organizations;
    @JsonProperty("uuid")
    private String uuid;
    @JsonProperty("thread")
    private Thread thread;
    @JsonProperty("author")
    private String author;
    @JsonProperty("url")
    private String url;
    @JsonProperty("ord_in_thread")
    private long ordInThread;
    @JsonProperty("title")
    private String title;
    @JsonProperty("locations")
    private Object[] locations;
    @JsonProperty("entities")
    private Entities entities;
    @JsonProperty("highlightText")
    private String highlightText;
    @JsonProperty("language")
    private String language;
    @JsonProperty("persons")
    private Object[] persons;
    @JsonProperty("text")
    private String text;
    @JsonProperty("external_links")
    private Object[] externalLinks;
    @JsonProperty("published")
    private String published;
    @JsonProperty("crawled")
    private String crawled;
    @JsonProperty("highlightTitle")
    private String highlightTitle;
}