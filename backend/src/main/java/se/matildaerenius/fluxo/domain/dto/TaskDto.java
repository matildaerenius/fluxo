package se.matildaerenius.fluxo.domain.dto;

import se.matildaerenius.fluxo.domain.entities.TaskPriority;
import se.matildaerenius.fluxo.domain.entities.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDateTime dueDate,
        TaskPriority priority,
        TaskStatus status
) {
}
