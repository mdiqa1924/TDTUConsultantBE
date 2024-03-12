package da2.g35.tdtuconsultantbe.service.impl;

import da2.g35.tdtuconsultantbe.entity.Combination;
import da2.g35.tdtuconsultantbe.entity.Major;
import da2.g35.tdtuconsultantbe.repository.CombinationRepository;
import da2.g35.tdtuconsultantbe.repository.MajorRepository;
import da2.g35.tdtuconsultantbe.repository.SubjectRepository;
import da2.g35.tdtuconsultantbe.service.CombinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Combination> getCombinationsByMajor(Long id) {
        return combinationRepository.findByMajorByCombination(majorRepository.findById(id).get());
    }

    @Override
    public List<Combination> getCombinationsBySubject(Long id) {
        return combinationRepository.findByCombinationSubjects(subjectRepository.findById(id).get());
    }
}
