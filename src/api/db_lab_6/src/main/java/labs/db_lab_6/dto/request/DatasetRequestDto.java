package labs.db_lab_6.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatasetRequestDto(
        Long responseId,
        String text,
        String imageUrl,
        String diagram,
        String label,
        String source
) {
}
