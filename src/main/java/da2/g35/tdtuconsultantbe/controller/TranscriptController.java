package da2.g35.tdtuconsultantbe.controller;

import da2.g35.tdtuconsultantbe.dto.TranscriptDTO;
import da2.g35.tdtuconsultantbe.entity.Transcript;
import da2.g35.tdtuconsultantbe.repository.TranscriptRepository;
import da2.g35.tdtuconsultantbe.service.TranscriptService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transcript")
public class TranscriptController {
    @Autowired
    private TranscriptService transcriptService;

//    @GetMapping(value = "/user/{id}")
//    public ResponseEntity<Object> getByUser(@Valid @PathVariable Long id){
//        TranscriptDTO.TranscriptResponse transcript = transcriptService.getTranscriptByUser(id);
//        return ResponseEntity.ok(transcript);
//    }

    @PostMapping(value = "/update/{id}")
    public ResponseEntity<Transcript> update(@Valid @PathVariable Long id, @RequestBody TranscriptDTO.TranscriptUpdateForm updateForm){
        Transcript transcript = transcriptService.update(id, updateForm);
        return ResponseEntity.ok(transcript);
    }
}
