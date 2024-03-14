package da2.g35.tdtuconsultantbe.controller;

import da2.g35.tdtuconsultantbe.dto.CombinationDTO;
import da2.g35.tdtuconsultantbe.entity.Combination;
import da2.g35.tdtuconsultantbe.repository.CombinationRepository;
import da2.g35.tdtuconsultantbe.service.CombinationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/combination")
public class CombinationController {
    @Autowired
    private CombinationService combinationService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getCombinationById(@Valid @PathVariable Long id){
        CombinationDTO.CombinationResponse response = combinationService.getCombinationById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/major/{id}")
    public ResponseEntity<List<CombinationDTO.CombinationResponse>> getCombinationsByMajor(@Valid @PathVariable Long id){
        List<CombinationDTO.CombinationResponse> combinations = combinationService.getCombinationsByMajor(id);
        return ResponseEntity.ok(combinations);
    }

    @GetMapping(value = "/subject/{id}")
    public ResponseEntity<List<CombinationDTO.CombinationResponse>> getCombinationsBySubject(@Valid @PathVariable Long id){
        List<CombinationDTO.CombinationResponse> combinations = combinationService.getCombinationsBySubject(id);
        return ResponseEntity.ok(combinations);
    }
}
