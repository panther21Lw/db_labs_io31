package labs.db_lab_6.dto.response;

import java.time.LocalDateTime;

public record DatasetResponseDto(
        Long id,
        Long responseId,
        String text,
        String imageUrl,
        String diagram,
        String label,
        String source,
        LocalDateTime createdAt
) {}
