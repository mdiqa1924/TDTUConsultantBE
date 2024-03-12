package da2.g35.tdtuconsultantbe.controller;

import da2.g35.tdtuconsultantbe.entity.Major;
import da2.g35.tdtuconsultantbe.service.MajorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/major")
public class MajorController {
    @Autowired
    private MajorService majorService;

    @GetMapping(value = "/faculty/{id}")
    public ResponseEntity<List<Major>> getMajorsByFaculty(@Valid @PathVariable Long id){
        List<Major> majors = majorService.getMajorsByFaculty(id);
        return ResponseEntity.ok(majors);
    }

    @GetMapping(value = "/hobby/{id}")
    public ResponseEntity<List<Major>> getMajorsByHobby(@Valid @PathVariable Long id){
        List<Major> majors = majorService.getMajorsByHobby(id);
        return ResponseEntity.ok(majors);
    }

    @GetMapping(value = "/combination/{id}")
    public ResponseEntity<List<Major>> getMajorsByCombination(@Valid @PathVariable Long id){
        List<Major> majors = majorService.getMajorsByCombination(id);
        return ResponseEntity.ok(majors);
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<List<Major>> getMajorsByUser(@Valid @PathVariable Long id){
        List<Major> majors = majorService.getMajorsByUser(id);
        return ResponseEntity.ok(majors);
    }
}
