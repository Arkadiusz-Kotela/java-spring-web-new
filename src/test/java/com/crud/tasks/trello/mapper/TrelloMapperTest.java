package com.crud.tasks.trello.mapper;

import com.crud.tasks.trello.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTest {

    @InjectMocks
    private TrelloMapper trelloMapper;

    @Test
    public void testMapToBoardsDto() {
        //Given
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        TrelloBoard board = new TrelloBoard("id_1", "name_1", new ArrayList<>());
        trelloBoards.add(board);
        TrelloList trelloList1 = new TrelloList("1", "list1", false);
        TrelloList trelloList2 = new TrelloList("2", "list2", false);
        TrelloList trelloList3 = new TrelloList("3", "list3", false);
        board.getLists().add(trelloList1);
        board.getLists().add(trelloList2);
        board.getLists().add(trelloList3);

        //When
        List<TrelloBoardDto> trelloBoardsDto = trelloMapper.mapToBoardsDto(trelloBoards);

        //Then
        assertEquals(1, trelloBoardsDto.size());
        assertEquals("id_1", trelloBoardsDto.get(0).getId());
        assertEquals("name_1", trelloBoardsDto.get(0).getName());
        assertEquals(3,trelloBoardsDto.get(0).getLists().size());
        assertEquals("1", trelloBoardsDto.get(0).getLists().get(0).getId());
        assertEquals("list1", trelloBoardsDto.get(0).getLists().get(0).getName());
        assertFalse(trelloBoardsDto.get(0).getLists().get(0).isClosed());

    }

    @Test
    public void testMapToBoards() {
        List<TrelloBoardDto> trelloBoardsDto = new ArrayList<>();
        TrelloBoardDto boardDto = new TrelloBoardDto("id_1", "name_1", new ArrayList<>());
        trelloBoardsDto.add(boardDto);
        TrelloListDto trelloList1 = new TrelloListDto("1", "list1", false);
        TrelloListDto trelloList2 = new TrelloListDto("2", "list2", false);
        TrelloListDto trelloList3 = new TrelloListDto("3", "list3", false);

        boardDto.getLists().add(trelloList1);
        boardDto.getLists().add(trelloList2);
        boardDto.getLists().add(trelloList3);

        //When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardsDto);

        //Then
        assertEquals(1, trelloBoards.size());
        assertEquals("id_1", trelloBoards.get(0).getId());
        assertEquals("name_1", trelloBoards.get(0).getName());
        assertEquals(3,trelloBoards.get(0).getLists().size());
        assertEquals("1", trelloBoards.get(0).getLists().get(0).getId());
        assertEquals("list1", trelloBoards.get(0).getLists().get(0).getName());
        assertFalse(trelloBoards.get(0).getLists().get(0).isClosed());

    }

    @Test
    public void testMapToTrelloCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto(
                "Test task",
                "Test Description",
                "top",
                "test_id"
        );

        //When
        TrelloCard card = trelloMapper.mapToTrelloCard(trelloCardDto);

        //Then
        assertEquals("Test task", card.getName());
        assertEquals("Test Description", card.getDescription());
        assertEquals("top", card.getPos());
        assertEquals("test_id", card.getListId());
    }

    @Test
    public void testMapToTrelloCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard(
                "Test task",
                "Test Description",
                "top",
                "test_id"
        );

        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToTrelloCardDto(trelloCard);

        //Then
        assertEquals("Test task", trelloCardDto.getName());
        assertEquals("Test Description", trelloCardDto.getDescription());
        assertEquals("top", trelloCardDto.getPos());
        assertEquals("test_id", trelloCardDto.getListId());
    }
}