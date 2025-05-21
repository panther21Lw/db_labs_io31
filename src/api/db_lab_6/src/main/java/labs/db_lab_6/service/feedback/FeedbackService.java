package labs.db_lab_6.service.feedback;

import labs.db_lab_6.dto.request.FeedbackRequestDto;
import labs.db_lab_6.dto.response.FeedbackResponseDto;
import labs.db_lab_6.entity.Feedback;
import labs.db_lab_6.service.BaseService;

public interface FeedbackService extends BaseService<FeedbackResponseDto, FeedbackRequestDto> {
}
