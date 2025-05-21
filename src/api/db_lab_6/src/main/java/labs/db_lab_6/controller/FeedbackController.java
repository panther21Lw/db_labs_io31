package labs.db_lab_6.controller;

import labs.db_lab_6.dto.request.FeedbackRequestDto;
import labs.db_lab_6.dto.response.FeedbackResponseDto;
import labs.db_lab_6.service.feedback.FeedbackService;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping("/feedbacks")
    public ResponseEntity<List<FeedbackResponseDto>> findAll(){
        List<FeedbackResponseDto> feedbacks = feedbackService.findAll();
        return ResponseEntity.ok(feedbacks);
    }

    @GetMapping("/feedbacks/{id}")
    public ResponseEntity<FeedbackResponseDto> findById(@PathVariable("id") Long id){
        FeedbackResponseDto feedback = feedbackService.findById(id);
        return ResponseEntity.ok(feedback);
    }

    @PostMapping("/feedbacks")
    public ResponseEntity<FeedbackResponseDto> save(@RequestBody FeedbackRequestDto dto){
        FeedbackResponseDto feedback = feedbackService.save(dto);
        return ResponseEntity.ok(feedback);
    }

    @PutMapping("/feedbacks/{id}")
    public ResponseEntity<FeedbackResponseDto> updateById(@PathVariable("id") Long id, @RequestBody FeedbackRequestDto dto){
        FeedbackResponseDto feedback = feedbackService.updateById(dto, id);
        return ResponseEntity.ok(feedback);
    }

    @DeleteMapping("/feedbacks/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Long id){
        return ResponseEntity.ok(feedbackService.deleteById(id));
    }
}
