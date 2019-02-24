package com.rdas.blogpostsmodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Entities {
    @JsonProperty("persons")
    private Location[] persons;

    @JsonProperty("locations")
    private Location[] locations;

    @JsonProperty("organizations")
    private Location[] organizations;
}