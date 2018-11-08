package com.crud.tasks.trello.domain;

import org.springframework.stereotype.Component;

@Component
public class TrelloList {
    private String id;
    private String name;
    private boolean isClosed;

    public TrelloList() {
    }

    public TrelloList(String id, String name, boolean isClosed) {
        this.id = id;
        this.name = name;
        this.isClosed = isClosed;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isClosed() {
        return isClosed;
    }
}
