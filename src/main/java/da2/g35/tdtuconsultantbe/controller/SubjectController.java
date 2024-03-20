package da2.g35.tdtuconsultantbe.controller;

import da2.g35.tdtuconsultantbe.dto.SubjectDTO;
import da2.g35.tdtuconsultantbe.entity.Subject;
import da2.g35.tdtuconsultantbe.service.SubjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
@CrossOrigin(origins = "http://localhost:5173/")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping(value = "/combination/{id}")
    public ResponseEntity<Object> getSubjectsByCombination(@Valid @PathVariable Long id){
        List<SubjectDTO.SubjectResponse> subjects = subjectService.getSubjectsByCombination(id);
        return ResponseEntity.ok(subjects);
    }
}
