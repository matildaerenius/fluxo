package se.matildaerenius.fluxo.services;

import se.matildaerenius.fluxo.domain.entities.TaskList;

import java.util.List;

public interface TaskListService {
    List<TaskList> listTasksLists();
}
