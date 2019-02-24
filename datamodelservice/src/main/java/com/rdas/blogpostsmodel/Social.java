package com.rdas.blogpostsmodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Social {
    private Gplus gplus;
    private Gplus pinterest;
    private Gplus vk;
    private Gplus linkedin;
    private Facebook facebook;
    private Gplus stumbledupon;

    @JsonProperty("gplus")
    public Gplus getGplus() { return gplus; }
    @JsonProperty("gplus")
    public void setGplus(Gplus value) { this.gplus = value; }

    @JsonProperty("pinterest")
    public Gplus getPinterest() { return pinterest; }
    @JsonProperty("pinterest")
    public void setPinterest(Gplus value) { this.pinterest = value; }

    @JsonProperty("vk")
    public Gplus getVk() { return vk; }
    @JsonProperty("vk")
    public void setVk(Gplus value) { this.vk = value; }

    @JsonProperty("linkedin")
    public Gplus getLinkedin() { return linkedin; }
    @JsonProperty("linkedin")
    public void setLinkedin(Gplus value) { this.linkedin = value; }

    @JsonProperty("facebook")
    public Facebook getFacebook() { return facebook; }
    @JsonProperty("facebook")
    public void setFacebook(Facebook value) { this.facebook = value; }

    @JsonProperty("stumbledupon")
    public Gplus getStumbledupon() { return stumbledupon; }
    @JsonProperty("stumbledupon")
    public void setStumbledupon(Gplus value) { this.stumbledupon = value; }
}