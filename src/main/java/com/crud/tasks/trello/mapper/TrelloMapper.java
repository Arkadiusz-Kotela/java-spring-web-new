package com.crud.tasks.trello.mapper;

import com.crud.tasks.trello.domain.*;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class TrelloMapper {

    public List<TrelloBoard> mapToBoards(final List<TrelloBoardDto> trelloBoardDto) {
        return trelloBoardDto.stream()
                .map(trelloBoard ->
                        new TrelloBoard(
                                trelloBoard.getId(),
                                trelloBoard.getName(),
                                mapToList(trelloBoard.getLists())))
                .collect(toList());
    }

    public List<TrelloBoardDto> mapToBoardsDto(final List<TrelloBoard> trelloBoards) {
        return trelloBoards.stream()
                .map(trelloBoardDto ->
                        new TrelloBoardDto(
                                trelloBoardDto.getId(),
                                trelloBoardDto.getName(),
                                mapToListDto(trelloBoardDto.getLists())))
                .collect(toList());
    }

    private List<TrelloList> mapToList(List<TrelloListDto> trelloListDto) {
        return trelloListDto.stream()
                .map(trelloList ->
                        new TrelloList(
                                trelloList.getId(),
                                trelloList.getName(),
                                trelloList.isClosed()))
                .collect(toList());
    }

    private List<TrelloListDto> mapToListDto(List<TrelloList> trelloList) {
        return trelloList.stream()
                .map(trelloListDto ->
                        new TrelloListDto(
                                trelloListDto.getId(),
                                trelloListDto.getName(),
                                trelloListDto.isClosed()))
                .collect(toList());
    }

    public TrelloCard mapToTrelloCard(final TrelloCardDto trelloCardDto) {
        return new TrelloCard(
                trelloCardDto.getName(),
                trelloCardDto.getDescription(),
                trelloCardDto.getPos(),
                trelloCardDto.getListId());
    }

    public TrelloCardDto mapToTrelloCardDto(final TrelloCard trelloCard) {
        return new TrelloCardDto(
                trelloCard.getName(),
                trelloCard.getDescription(),
                trelloCard.getPos(),
                trelloCard.getListId());
    }
}
