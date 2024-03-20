package da2.g35.tdtuconsultantbe.controller;

import da2.g35.tdtuconsultantbe.dto.HobbyDTO;
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
@CrossOrigin(origins = "http://localhost:5173/")
public class HobbyController {
    @Autowired
    private HobbyService hobbyService;

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<Object> getHobbiesByUser(@Valid @PathVariable Long id){
        List<HobbyDTO.HobbyResponse> hobbies = hobbyService.getHobbiesByUser(id);
        return ResponseEntity.ok(hobbies);
    }

    @PostMapping(value = "/test_result")
    public ResponseEntity<Object> getMBTIResult(@Valid @RequestBody HobbyDTO.MBTITestResult result){
        HobbyDTO.MBTITestResponse response = hobbyService.testResponse(result);
        return ResponseEntity.ok(response);
    }
}
