package da2.g35.tdtuconsultantbe.controller;

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

    @GetMapping(value = "/major/{id}")
    public ResponseEntity<List<Combination>> getCombinationsByMajor(@Valid @PathVariable Long id){
        List<Combination> combinations = combinationService.getCombinationsByMajor(id);
        return ResponseEntity.ok(combinations);
    }

    @GetMapping(value = "/subject/{id}")
    public ResponseEntity<List<Combination>> getCombinationsBySubject(@Valid @PathVariable Long id){
        List<Combination> combinations = combinationService.getCombinationsBySubject(id);
        return ResponseEntity.ok(combinations);
    }
}
