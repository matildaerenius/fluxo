package se.matildaerenius.fluxo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.matildaerenius.fluxo.domain.dto.TaskListDto;
import se.matildaerenius.fluxo.mappers.TaskListMapper;
import se.matildaerenius.fluxo.services.TaskListService;

import java.util.List;

@RestController
@RequestMapping(path = "/task-lists")
public class TaskListController {

    private final TaskListService taskListService;
    private final TaskListMapper taskListMapper;

    public TaskListController(TaskListService taskListService, TaskListMapper taskListMapper) {
        this.taskListService = taskListService;
        this.taskListMapper = taskListMapper;
    }

    @GetMapping
    public List<TaskListDto> listTaskLists() {
        return taskListService.listTasksLists()
                .stream()
                .map(taskListMapper::toDto)
                .toList();
    }
}
