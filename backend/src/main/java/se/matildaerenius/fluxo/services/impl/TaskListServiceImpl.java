package se.matildaerenius.fluxo.services.impl;

import org.springframework.stereotype.Service;
import se.matildaerenius.fluxo.domain.entities.TaskList;
import se.matildaerenius.fluxo.repositories.TaskListRepository;
import se.matildaerenius.fluxo.services.TaskListService;

import java.util.List;

@Service
public class TaskListServiceImpl implements TaskListService {

    private final TaskListRepository taskListRepository;

    public TaskListServiceImpl(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    @Override
    public List<TaskList> listTasksLists() {
        return taskListRepository.findAll();
    }
}
