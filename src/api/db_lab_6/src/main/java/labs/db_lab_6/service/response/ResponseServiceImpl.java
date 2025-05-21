package labs.db_lab_6.service.response;

import labs.db_lab_6.dto.request.ResponseDto;
import labs.db_lab_6.entity.Response;
import labs.db_lab_6.exception.ResourceNotFoundException;
import labs.db_lab_6.mapper.ResponseMapper;
import labs.db_lab_6.repository.DatasetRepository;
import labs.db_lab_6.repository.FeedbackRepository;
import labs.db_lab_6.repository.ResponseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseServiceImpl implements ResponseService {

    private final ResponseRepository responseRepository;
    private final DatasetRepository datasetRepository;
    private final FeedbackRepository feedbackRepository;

    public ResponseServiceImpl(DatasetRepository datasetRepository,
                               ResponseRepository responseRepository,
                               FeedbackRepository feedbackRepository) {
        this.datasetRepository = datasetRepository;
        this.responseRepository = responseRepository;
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public List<Response> findAll() {
        return responseRepository.findAll();
    }

    @Override
    public Response findById(Long id) {
        if (id == null){
            throw new IllegalArgumentException("Wrong id provided");
        }
        return responseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No resource with id:" + id));
    }

    @Override
    public Response save(ResponseDto dto) {
        if (dto == null){
            throw new IllegalArgumentException("Wrong data provided");
        }
        Response response = ResponseMapper.toEntity(dto, datasetRepository, feedbackRepository);
        return responseRepository.save(response);
    }

    @Override
    public Response updateById(ResponseDto dto, Long id) {
        if (id == null || dto == null){
            throw new IllegalArgumentException("Wrong data provided");
        }

        if (responseRepository.existsById(id)){
            Response response = ResponseMapper.toEntity(dto, datasetRepository, feedbackRepository);
            response.setId(id);
            return responseRepository.save(response);
        }
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        if (responseRepository.existsById (id)){
            responseRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
