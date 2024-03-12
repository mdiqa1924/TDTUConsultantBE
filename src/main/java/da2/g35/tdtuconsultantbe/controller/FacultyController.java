package da2.g35.tdtuconsultantbe.controller;

import da2.g35.tdtuconsultantbe.entity.Faculty;
import da2.g35.tdtuconsultantbe.service.FacultyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @GetMapping(value = "/")
    public ResponseEntity<List<Faculty>> getListFaculty(){
        List<Faculty> faculties = facultyService.getListFaculty();
        return ResponseEntity.ok().body(faculties);
    }
    @GetMapping(value = "/major/{id}")
    public ResponseEntity<Faculty> getFacultyByMajor(@Valid  @PathVariable Long id){
        Faculty faculty = facultyService.getFacultyByMajor(id);
        return ResponseEntity.ok(faculty);
    }
}
