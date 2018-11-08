package com.crud.tasks.trello.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.trello.domain.CreatedTrelloCardDto;
import com.crud.tasks.trello.domain.TrelloBoardDto;
import com.crud.tasks.trello.domain.TrelloCardDto;
import com.crud.tasks.service.SimpleEmailService;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Optional.ofNullable;

@Service
public class TrelloService {
    private static final String SUBJECT = "Tasks: new Trello card";

    private final AdminConfig adminConfig;
    private final TrelloClient trelloClient;
    private final SimpleEmailService emailService;

    @Autowired
    public TrelloService(AdminConfig adminConfig, TrelloClient trelloClient, SimpleEmailService emailService) {
        this.adminConfig = adminConfig;
        this.trelloClient = trelloClient;
        this.emailService = emailService;
    }

    public List<TrelloBoardDto> fetchTrelloBoards() {
        return trelloClient.getTrelloBoards();
    }

    public CreatedTrelloCardDto createdTrelloCard(final TrelloCardDto trelloCardDto) {
        CreatedTrelloCardDto newCard = trelloClient.createNewCard(trelloCardDto);
        ofNullable(newCard).ifPresent(card -> emailService.send(new Mail(
                adminConfig.getAdminMail(),
                null,
                SUBJECT,
                "New Trello Card " + card.getName() + " has been created on your Trello account"
        )));
        return newCard;
    }
}

