package labs.db_lab_6.mapper;

import labs.db_lab_6.dto.request.ResponseDto;
import labs.db_lab_6.entity.Response;
import labs.db_lab_6.repository.DatasetRepository;
import labs.db_lab_6.repository.FeedbackRepository;

import java.util.Collections;

public class ResponseMapper {

    public static Response toEntity(
            ResponseDto dto,
            DatasetRepository datasetRepository,
            FeedbackRepository feedbackRepository)
    {
        Response response = new Response();

        response.setUserId(dto.userId());
        response.setGraphic(dto.graphic());
        response.setDescription(dto.description());

        if (dto.datasetIds() == null){
            response.setDatasets(Collections.emptyList());
        } else {
            response.setDatasets(
                    dto.datasetIds().stream()
                            .map(datasetId -> datasetRepository.findById(datasetId).orElse(null))
                            .toList()
            );
        }

        if (dto.feedbackIds() == null){
            response.setFeedbacks(Collections.emptyList());
        } else {
            response.setFeedbacks(
                    dto.feedbackIds().stream()
                            .map(feedbackId -> feedbackRepository.findById(feedbackId).orElse(null))
                            .toList()
            );
        }



        return response;
    }
}
