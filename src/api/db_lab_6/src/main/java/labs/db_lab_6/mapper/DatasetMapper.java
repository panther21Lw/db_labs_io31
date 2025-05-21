package labs.db_lab_6.mapper;

import labs.db_lab_6.dto.request.DatasetRequestDto;
import labs.db_lab_6.dto.response.DatasetResponseDto;
import labs.db_lab_6.entity.Dataset;
import labs.db_lab_6.repository.ResponseRepository;

import java.time.LocalDateTime;

public class DatasetMapper {

    public static Dataset toEntity(DatasetRequestDto dto, ResponseRepository repository){
        Dataset dataset = new Dataset();

        if (dto.responseId() != null){
            dataset.setResponse(repository.findById(dto.responseId()).orElse(null));
        }

        dataset.setText(dto.text());
        dataset.setImageUrl(dto.imageUrl());
        dataset.setDiagram(dto.diagram());
        dataset.setLabel(dto.label());
        dataset.setSource(dto.source());
        dataset.setCreatedAt(LocalDateTime.now());


        return dataset;
    }

    public static DatasetResponseDto toDto(Dataset entity){
        return new DatasetResponseDto(
                entity.getId(),
                entity.getResponse() != null ? entity.getResponse().getId() : null,
                entity.getText(),
                entity.getImageUrl(),
                entity.getDiagram(),
                entity.getLabel(),
                entity.getSource(),
                entity.getCreatedAt()
        );
    }
}
