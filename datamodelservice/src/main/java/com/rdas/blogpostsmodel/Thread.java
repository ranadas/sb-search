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
public class Thread {
    @JsonProperty("social")
    private Social social;
    @JsonProperty("site_full")
    private String siteFull;
    @JsonProperty("main_image")
    private String mainImage;
    @JsonProperty("site_section")
    private String siteSection;
    @JsonProperty("section_title")
    private String sectionTitle;
    @JsonProperty("url")
    private String url;
    @JsonProperty("country")
    private String country;
    @JsonProperty("domain_rank")
    private long domainRank;
    @JsonProperty("title")
    private String title;
    @JsonProperty("performance_score")
    private long performanceScore;
    @JsonProperty("site")
    private String site;
    @JsonProperty("participants_count")
    private long participantsCount;
    @JsonProperty("title_full")
    private String titleFull;
    @JsonProperty("spam_score")
    private long spamScore;
    @JsonProperty("site_type")
    private String siteType;
    @JsonProperty("published")
    private String published;
    @JsonProperty("replies_count")
    private long repliesCount;
    @JsonProperty("uuid")
    private String uuid;
}