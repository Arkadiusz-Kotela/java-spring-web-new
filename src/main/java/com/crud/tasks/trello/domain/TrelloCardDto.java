package com.crud.tasks.trello.domain;

public class TrelloCardDto {
    private String name;
    private String description;
    private String pos;
    private String listId;

    private TrelloCardDto() {
    }

    public TrelloCardDto(final String name,
                         final String description,
                         final String pos, final String listId) {
        this.name = name;
        this.description = description;
        this.pos = pos;
        this.listId = listId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPos() {
        return pos;
    }

    public String getListId() {
        return listId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }
}
