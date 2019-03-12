package com.rdas.blogpostsmodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter @Setter @ToString @EqualsAndHashCode
public class Location implements Serializable {
    @JsonProperty("name")
    private String name;

    @JsonProperty("sentiment")
    private Sentiment sentiment;
}