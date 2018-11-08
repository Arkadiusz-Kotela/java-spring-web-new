package com.crud.tasks.trello.validator;

import com.crud.tasks.trello.domain.TrelloBoard;
import com.crud.tasks.trello.domain.TrelloCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TrelloValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger(TrelloValidator.class);

    public void validateTrelloCard(final TrelloCard trelloCard) {
        if (trelloCard.getName().contains("test")) {
            LOGGER.info("Someone is testing the application");
        } else {
            LOGGER.info("Application might be used in a proper way");
        }
    }

    public List<TrelloBoard> validateTrelloBoard(final List<TrelloBoard> trelloBoards) {
        LOGGER.info("Starting filtering boards ...");
        List<TrelloBoard> filteredBoards = trelloBoards.stream()
                .filter(trelloBoard -> !trelloBoard.getName().equalsIgnoreCase("test"))
                .collect(Collectors.toList());
        LOGGER.info("Size of filetered boards is: " + filteredBoards.size());
        return filteredBoards;
    }
}
