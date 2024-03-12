package da2.g35.tdtuconsultantbe.service.impl;

import da2.g35.tdtuconsultantbe.entity.Combination;
import da2.g35.tdtuconsultantbe.entity.Subject;
import da2.g35.tdtuconsultantbe.repository.CombinationRepository;
import da2.g35.tdtuconsultantbe.repository.SubjectRepository;
import da2.g35.tdtuconsultantbe.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImp implements SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private CombinationRepository combinationRepository;
    @Override
    public List<Subject> getSubjectsByCombination(Long id) {
        return subjectRepository.findByCombinationBySubject(combinationRepository.findById(id).get());
    }
}
