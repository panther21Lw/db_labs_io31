package labs.db_lab_6.dto.response;

public record FeedbackResponseDto(
        Long id,
        Long responseId,
        Long userId,
        String title,
        String comment
) {}
