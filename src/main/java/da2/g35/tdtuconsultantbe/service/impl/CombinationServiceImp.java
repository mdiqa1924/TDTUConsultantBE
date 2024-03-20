package da2.g35.tdtuconsultantbe.service.impl;

import da2.g35.tdtuconsultantbe.dto.CombinationDTO;
import da2.g35.tdtuconsultantbe.entity.Combination;
import da2.g35.tdtuconsultantbe.entity.Major;
import da2.g35.tdtuconsultantbe.entity.Subject;
import da2.g35.tdtuconsultantbe.repository.CombinationRepository;
import da2.g35.tdtuconsultantbe.repository.MajorRepository;
import da2.g35.tdtuconsultantbe.repository.SubjectRepository;
import da2.g35.tdtuconsultantbe.service.CombinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CombinationServiceImp implements CombinationService {
    @Autowired
    private CombinationRepository combinationRepository;
    @Autowired
    private MajorRepository majorRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public CombinationDTO.CombinationResponse getCombinationById(Long id) {
        Combination combination = combinationRepository.findById(id).get();
        return formatCombinationResponse(combination);
    }

    @Override
    public List<CombinationDTO.CombinationResponse> getCombinationsByMajor(Long id) {
        List<CombinationDTO.CombinationResponse> responses = new ArrayList<>();
        List<Combination> combinations = combinationRepository.findCombinationsByMajorByCombinationContains(majorRepository.findById(id).get());
        for (Combination c:combinations){
            responses.add(formatCombinationResponse(c));
        }
        return responses;
    }

    @Override
    public List<CombinationDTO.CombinationResponse> getCombinationsBySubject(Long id) {
        List<CombinationDTO.CombinationResponse> responses = new ArrayList<>();
        List<Combination> combinations = combinationRepository.findCombinationsByCombinationSubjectsContains(subjectRepository.findById(id).get());
        for (Combination c : combinations) {
            responses.add(formatCombinationResponse(c));
        }
        return responses;
    }

    public CombinationDTO.CombinationResponse formatCombinationResponse(Combination combination){
        CombinationDTO.CombinationResponse response = new CombinationDTO.CombinationResponse();
        response.setName(combination.getName());
        return response;
    }
}
