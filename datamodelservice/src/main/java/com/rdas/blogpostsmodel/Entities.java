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
public class Entities implements Serializable {
    @JsonProperty("persons")
    private Location[] persons;

    @JsonProperty("locations")
    private Location[] locations;

    @JsonProperty("organizations")
    private Location[] organizations;
}