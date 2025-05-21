package labs.db_lab_6.controller;

import labs.db_lab_6.dto.request.ResponseDto;
import labs.db_lab_6.entity.Response;
import labs.db_lab_6.service.response.ResponseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ResponseController {

    private final ResponseService responseService;

    public ResponseController(ResponseService responseService) {
        this.responseService = responseService;
    }

    @GetMapping("/responses")
    public ResponseEntity<List<Response>> findAll(){
        List<Response> responses = responseService.findAll();
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/responses/{id}")
    public ResponseEntity<Response> findById(@PathVariable("id") Long id){
        Response response = responseService.findById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/responses")
    public ResponseEntity<Response> save(@RequestBody ResponseDto dto){
        Response response = responseService.save(dto);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/responses/{id}")
    public ResponseEntity<Response> updateById(@PathVariable("id") Long id, @RequestBody ResponseDto dto){
        Response response = responseService.updateById(dto, id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/responses/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Long id){
        return ResponseEntity.ok(responseService.deleteById(id));
    }
}
