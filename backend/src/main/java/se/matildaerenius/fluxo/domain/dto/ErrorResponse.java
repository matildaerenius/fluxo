package se.matildaerenius.fluxo.domain.dto;

public record ErrorResponse(
        int status,
        String message,
        String details
) {
}
