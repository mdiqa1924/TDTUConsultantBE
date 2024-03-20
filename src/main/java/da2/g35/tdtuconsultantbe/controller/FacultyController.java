package da2.g35.tdtuconsultantbe.controller;

import da2.g35.tdtuconsultantbe.dto.FacultyDTO;
import da2.g35.tdtuconsultantbe.entity.Faculty;
import da2.g35.tdtuconsultantbe.entity.Hobby;
import da2.g35.tdtuconsultantbe.repository.FacultyRepository;
import da2.g35.tdtuconsultantbe.repository.HobbyRepository;
import da2.g35.tdtuconsultantbe.service.FacultyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculty")
@CrossOrigin(origins = "http://localhost:5173/")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @GetMapping(value = "/")
    public ResponseEntity<List<FacultyDTO.FacultyResponse>> getListFaculty(){
        List<FacultyDTO.FacultyResponse> faculties = facultyService.getListFaculty();
        return ResponseEntity.ok(faculties);
    }
    @GetMapping(value = "/major/{id}")
    public ResponseEntity<Object> getFacultyByMajor(@Valid  @PathVariable Long id){
        FacultyDTO.FacultyResponse response = facultyService.getFacultyByMajor(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getFacultyById(@Valid @PathVariable Long id){
        FacultyDTO.FacultyResponse response = facultyService.getFacultyById(id);
        return ResponseEntity.ok(response);
    }

}
