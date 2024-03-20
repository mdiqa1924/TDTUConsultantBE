package da2.g35.tdtuconsultantbe.controller;

import da2.g35.tdtuconsultantbe.dto.MajorDTO;
import da2.g35.tdtuconsultantbe.entity.Major;
import da2.g35.tdtuconsultantbe.service.MajorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/major")
@CrossOrigin(origins = "http://localhost:5173/")
public class MajorController {
    @Autowired
    private MajorService majorService;

    @GetMapping(value = "/")
    public ResponseEntity<List<MajorDTO.MajorResponse>> getAllMajors(){
        List<MajorDTO.MajorResponse> responses = majorService.getAllMajors();
        return ResponseEntity.ok(responses);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getMajorById(@Valid @PathVariable Long id){
        MajorDTO.MajorDetailResponse response = majorService.getDetailMajor(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/faculty/{id}")
    public ResponseEntity<List<MajorDTO.MajorResponse>> getMajorsByFaculty(@Valid @PathVariable Long id){
        List<MajorDTO.MajorResponse> majors = majorService.getMajorsByFaculty(id);
        return ResponseEntity.ok(majors);
    }

    @GetMapping(value = "/hobby/{id}")
    public ResponseEntity<List<MajorDTO.MajorResponse>> getMajorsByHobby(@Valid @PathVariable Long id){
        List<MajorDTO.MajorResponse> responses = majorService.getMajorsByHobby(id);
        return ResponseEntity.ok(responses);
    }

    @GetMapping(value = "/combination/{id}")
    public ResponseEntity<List<MajorDTO.MajorResponse>> getMajorsByCombination(@Valid @PathVariable Long id){
        List<MajorDTO.MajorResponse> responses = majorService.getMajorsByCombination(id);
        return ResponseEntity.ok(responses);
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<List<MajorDTO.MajorResponse>> getMajorsByUser(@Valid @PathVariable Long id){
        List<MajorDTO.MajorResponse> responses = majorService.getMajorsByUser(id);
        return ResponseEntity.ok(responses);
    }

}
