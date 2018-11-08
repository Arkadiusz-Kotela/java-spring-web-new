package com.crud.tasks.trello.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TrelloBoardDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("lists")
    private List<TrelloListDto> lists;

    private TrelloBoardDto() {
    }

    public TrelloBoardDto(String id, String name, List<TrelloListDto> lists) {
        this.id = id;
        this.name = name;
        this.lists = lists;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<TrelloListDto> getLists() {
        return lists;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLists(List<TrelloListDto> lists) {
        this.lists = lists;
    }
}
