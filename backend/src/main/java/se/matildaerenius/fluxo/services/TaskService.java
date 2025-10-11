package se.matildaerenius.fluxo.services;

import se.matildaerenius.fluxo.domain.entities.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    List<Task> listTasks(UUID taskListId);
}
