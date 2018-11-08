package com.crud.tasks.trello.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatedTrelloCardDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("shortUrl")
    private String shortUrl;

//    @JsonProperty("badges")
//    private BadgesDto badgesDto;
//
//    @JsonProperty("attachmentsByType")
//    private AttachmentsByTypeDto attachmentsByTypeDto;
//
//    @JsonProperty("trello")
//    private TrelloDto trelloDto;


    private CreatedTrelloCardDto() {
    }

}
