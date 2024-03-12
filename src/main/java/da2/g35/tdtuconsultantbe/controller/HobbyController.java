package da2.g35.tdtuconsultantbe.controller;

import da2.g35.tdtuconsultantbe.entity.Hobby;
import da2.g35.tdtuconsultantbe.entity.Major;
import da2.g35.tdtuconsultantbe.service.HobbyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hobby")
public class HobbyController {
    @Autowired
    private HobbyService hobbyService;

    @GetMapping(value = "/major/{id}")
    public ResponseEntity<List<Hobby>> getHobbiesByMajor(@Valid @PathVariable Long id){
        List<Hobby> hobbies = hobbyService.getHobbiesByMajor(id);
        return ResponseEntity.ok(hobbies);
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<List<Hobby>> getHobbiesByUser(@Valid @PathVariable Long id){
        List<Hobby> hobbies = hobbyService.getHobbiesByUser(id);
        return ResponseEntity.ok(hobbies);
    }
}
