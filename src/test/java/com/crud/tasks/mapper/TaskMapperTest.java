package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.data.mapping.Alias.ofNullable;

@RunWith(MockitoJUnitRunner.class)
public class TaskMapperTest {

    @InjectMocks
    private TaskMapper taskMapper;

    @Test
    public void testMapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "new_task", "new_content");

        //When
        Task task = taskMapper.mapToTask(taskDto);
        long id = task.getId();

        //Then
        assertEquals(1L, id);
        assertEquals("new_task", task.getTitle());
        assertEquals("new_content", task.getContent());
    }

    @Test
    public void testMapToTaskDto() {
        //Given
        Task task = new Task(1L, "new_task", "new_content");

        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        long id = taskDto.getId();

        //Then
        assertEquals(1L, id);
        assertEquals("new_task", taskDto.getTitle());
        assertEquals("new_content", taskDto.getContent());

    }

    @Test
    public void testMapTaskDtoList() {
        //Given
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1L, "new_task1", "new_content1"));
        tasks.add(new Task(2L, "new_task2", "new_content2"));
        tasks.add(new Task(3L, "new_task3", "new_content3"));

        //When
        List<TaskDto> taskDtos = taskMapper.mapTaskDtoList(tasks);
        long id1 = taskDtos.get(0).getId();

        //Then
        assertEquals(3, taskDtos.size());
        assertEquals(1L, id1);
        assertEquals("new_task2", taskDtos.get(1).getTitle());
        assertEquals("new_content3", taskDtos.get(2).getContent());
    }
}