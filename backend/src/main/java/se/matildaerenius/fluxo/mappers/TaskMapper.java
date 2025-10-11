package se.matildaerenius.fluxo.mappers;

import se.matildaerenius.fluxo.domain.dto.TaskDto;
import se.matildaerenius.fluxo.domain.entities.Task;

public interface TaskMapper {

    Task fromDto(TaskDto taskDto);
    TaskDto toDto(Task task);
}
