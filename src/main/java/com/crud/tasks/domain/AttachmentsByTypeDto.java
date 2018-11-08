package com.crud.tasks.domain;

import com.crud.tasks.trello.domain.TrelloDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AttachmentsByTypeDto {

    @JsonProperty("attachmentsByType")
    private TrelloDto trellos;

    private AttachmentsByTypeDto() {
    }
}
