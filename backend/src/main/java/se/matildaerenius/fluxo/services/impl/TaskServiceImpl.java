package se.matildaerenius.fluxo.services.impl;

import org.springframework.stereotype.Service;
import se.matildaerenius.fluxo.domain.entities.Task;
import se.matildaerenius.fluxo.repositories.TaskRepository;
import se.matildaerenius.fluxo.services.TaskService;

import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> listTasks(UUID taskListId) {
        return taskRepository.findByTaskListId(taskListId);
    }
}
