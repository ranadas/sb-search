package com.rdas.blogpostsmodel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;

public enum Sentiment {
    NEGATIVE, NEUTRAL, NONE;

    @JsonValue
    public String toValue() {
        switch (this) {
            case NEGATIVE:
                return "negative";
            case NEUTRAL:
                return "neutral";
            case NONE:
                return "none";
        }
        return null;
    }

    @JsonCreator
    public static Sentiment forValue(String value) throws IOException {
        if (value.equals("negative")) return NEGATIVE;
        if (value.equals("neutral")) return NEUTRAL;
        if (value.equals("none")) return NONE;
        throw new IOException("Cannot deserialize Sentiment");
    }
}