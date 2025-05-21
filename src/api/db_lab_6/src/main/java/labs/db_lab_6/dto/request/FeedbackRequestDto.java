package labs.db_lab_6.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record FeedbackRequestDto(
        Long responseId,
        Long userId,
        String title,
        String comment
) {}
