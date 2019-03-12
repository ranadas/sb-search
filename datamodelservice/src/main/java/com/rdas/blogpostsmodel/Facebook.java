package com.rdas.blogpostsmodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Facebook implements Serializable {
    private long likes;
    private long shares;
    private long comments;

    @JsonProperty("likes")
    public long getLikes() { return likes; }
    @JsonProperty("likes")
    public void setLikes(long value) { this.likes = value; }

    @JsonProperty("shares")
    public long getShares() { return shares; }
    @JsonProperty("shares")
    public void setShares(long value) { this.shares = value; }

    @JsonProperty("comments")
    public long getComments() { return comments; }
    @JsonProperty("comments")
    public void setComments(long value) { this.comments = value; }
}