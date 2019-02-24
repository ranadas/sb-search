package com.rdas.blogpostsmodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @EqualsAndHashCode
public class Location {
    @JsonProperty("name")
    private String name;

    @JsonProperty("sentiment")
    private Sentiment sentiment;
}