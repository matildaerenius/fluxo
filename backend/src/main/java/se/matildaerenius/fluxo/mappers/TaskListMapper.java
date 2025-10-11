package se.matildaerenius.fluxo.mappers;

import se.matildaerenius.fluxo.domain.dto.TaskListDto;
import se.matildaerenius.fluxo.domain.entities.TaskList;

public interface TaskListMapper {

    TaskList fromDto(TaskListDto taskListDto);
    TaskListDto toDto(TaskList taskList);
}
