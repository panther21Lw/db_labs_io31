package labs.db_lab_6.controller;

import labs.db_lab_6.dto.request.DatasetRequestDto;
import labs.db_lab_6.dto.response.DatasetResponseDto;
import labs.db_lab_6.service.dataset.DatasetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DatasetController {

    private final DatasetService datasetService;

    public DatasetController(DatasetService datasetService) {
        this.datasetService = datasetService;
    }

    @GetMapping("/datasets")
    public ResponseEntity<List<DatasetResponseDto>> findAll(){
        List<DatasetResponseDto> datasets = datasetService.findAll();
        return ResponseEntity.ok(datasets);
    }

    @GetMapping("/datasets/{id}")
    public ResponseEntity<DatasetResponseDto> findById(@PathVariable("id") Long id){
        DatasetResponseDto dataset = datasetService.findById(id);
        return ResponseEntity.ok(dataset);
    }

    @PostMapping("/datasets")
    public ResponseEntity<DatasetResponseDto> save(@RequestBody DatasetRequestDto dto){
        DatasetResponseDto dataset = datasetService.save(dto);
        return ResponseEntity.ok(dataset);
    }

    @PutMapping("/datasets/{id}")
    public ResponseEntity<DatasetResponseDto> updateById(@PathVariable("id") Long id, @RequestBody DatasetRequestDto dto){
        DatasetResponseDto dataset = datasetService.updateById(dto, id);
        return ResponseEntity.ok(dataset);
    }

    @DeleteMapping("/datasets/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Long id){
        return ResponseEntity.ok(datasetService.deleteById(id));
    }
}
