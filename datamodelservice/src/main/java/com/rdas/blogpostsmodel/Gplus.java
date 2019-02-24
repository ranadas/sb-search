package com.rdas.blogpostsmodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Gplus {
    private long shares;

    @JsonProperty("shares")
    public long getShares() { return shares; }
    @JsonProperty("shares")
    public void setShares(long value) { this.shares = value; }
}
