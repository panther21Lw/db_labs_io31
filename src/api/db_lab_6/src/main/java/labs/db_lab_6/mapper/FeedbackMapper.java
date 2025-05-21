package labs.db_lab_6.mapper;

import labs.db_lab_6.dto.request.FeedbackRequestDto;
import labs.db_lab_6.dto.response.FeedbackResponseDto;
import labs.db_lab_6.entity.Feedback;
import labs.db_lab_6.repository.ResponseRepository;

public class FeedbackMapper {

    public static Feedback toEntity(FeedbackRequestDto dto, ResponseRepository repository){
        Feedback feedback = new Feedback();
        if (dto.responseId() != null) {
            feedback.setResponse(repository.findById(dto.responseId()).orElse(null));
        }

        feedback.setUserId(dto.userId());
        feedback.setTitle(dto.title());
        feedback.setComment(dto.comment());

        return feedback;
    }

    public static FeedbackResponseDto toDto(Feedback entity){
        return new FeedbackResponseDto(
                entity.getId(),
                entity.getResponse() != null ? entity.getResponse().getId() : null,
                entity.getUserId(),
                entity.getTitle(),
                entity.getComment()
        );
    }
}
