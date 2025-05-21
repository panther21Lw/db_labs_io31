package labs.db_lab_6.service.dataset;

import labs.db_lab_6.dto.request.DatasetRequestDto;
import labs.db_lab_6.dto.response.DatasetResponseDto;
import labs.db_lab_6.entity.Dataset;
import labs.db_lab_6.exception.ResourceNotFoundException;
import labs.db_lab_6.mapper.DatasetMapper;
import labs.db_lab_6.repository.DatasetRepository;
import labs.db_lab_6.repository.ResponseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatasetServiceImpl implements DatasetService {

    private final DatasetRepository datasetRepository;
    private final ResponseRepository responseRepository;

    public DatasetServiceImpl(DatasetRepository datasetRepository, ResponseRepository responseRepository) {
        this.datasetRepository = datasetRepository;
        this.responseRepository = responseRepository;
    }

    @Override
    public List<DatasetResponseDto> findAll() {
        return datasetRepository.findAll().stream()
                .map(DatasetMapper::toDto).toList();
    }

    @Override
    public DatasetResponseDto findById(Long id) {
        if (id == null){
            throw new IllegalArgumentException("Wrong id provided");
        }
        return DatasetMapper.toDto(datasetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No resource with id:" + id)));
    }

    @Override
    public DatasetResponseDto save(DatasetRequestDto dto) {
        if (dto == null){
            throw new IllegalArgumentException("Wrong data provided");
        }
        Dataset dataset = DatasetMapper.toEntity(dto, responseRepository);
        return DatasetMapper.toDto(datasetRepository.save(dataset));
    }

    @Override
    public DatasetResponseDto updateById(DatasetRequestDto dto, Long id) {
        if (id == null || dto == null){
            throw new IllegalArgumentException("Wrong data provided");
        }

        if (datasetRepository.existsById(id)){
            Dataset dataset = DatasetMapper.toEntity(dto, responseRepository);
            dataset.setId(id);
            return DatasetMapper.toDto(datasetRepository.save(dataset));
        }
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        if (datasetRepository.existsById (id)){
            datasetRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
