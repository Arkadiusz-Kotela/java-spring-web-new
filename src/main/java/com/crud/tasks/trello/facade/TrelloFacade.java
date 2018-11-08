package com.crud.tasks.trello.facade;

import com.crud.tasks.trello.domain.*;
import com.crud.tasks.trello.mapper.TrelloMapper;
import com.crud.tasks.trello.service.TrelloService;
import com.crud.tasks.trello.validator.TrelloValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TrelloFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(TrelloFacade.class);
    private final TrelloService trelloService;
    private final TrelloMapper trelloMapper;
    private final TrelloValidator trelloValidator;

    @Autowired
    public TrelloFacade(final TrelloService trelloService,
                        final TrelloMapper trelloMapper,
                        final TrelloValidator trelloValidator) {
        this.trelloService = trelloService;
        this.trelloMapper = trelloMapper;
        this.trelloValidator = trelloValidator;
    }

    public List<TrelloBoardDto> fetchTrelloBoards() {
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloService.fetchTrelloBoards());
        List<TrelloBoard> filteredTrelloBoards = trelloValidator.validateTrelloBoard(trelloBoards);
        return trelloMapper.mapToBoardsDto(filteredTrelloBoards);
    }

    public CreatedTrelloCardDto createCard(final TrelloCardDto trelloCardDto) {
        TrelloCard trelloCard = trelloMapper.mapToTrelloCard(trelloCardDto);
        trelloValidator.validateTrelloCard(trelloCard);
        return trelloService.createdTrelloCard(trelloMapper.mapToTrelloCardDto(trelloCard));
    }
}
