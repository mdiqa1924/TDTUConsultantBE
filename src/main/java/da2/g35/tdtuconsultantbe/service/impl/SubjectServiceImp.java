package da2.g35.tdtuconsultantbe.service.impl;

import da2.g35.tdtuconsultantbe.dto.SubjectDTO;
import da2.g35.tdtuconsultantbe.entity.Combination;
import da2.g35.tdtuconsultantbe.entity.Subject;
import da2.g35.tdtuconsultantbe.repository.CombinationRepository;
import da2.g35.tdtuconsultantbe.repository.SubjectRepository;
import da2.g35.tdtuconsultantbe.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectServiceImp implements SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private CombinationRepository combinationRepository;
    @Override
    public List<SubjectDTO.SubjectResponse> getSubjectsByCombination(Long id) {
        List<SubjectDTO.SubjectResponse> responses = new ArrayList<>();
        List<Subject> subjects = subjectRepository.findSubjectsByCombinationBySubjectContains(combinationRepository.findById(id).get());
        for(Subject s:subjects){
            responses.add(formatSubjectResponse(s));
        }
        return responses;
    }

    public SubjectDTO.SubjectResponse formatSubjectResponse(Subject subject){
        SubjectDTO.SubjectResponse response = new SubjectDTO.SubjectResponse();
        response.setId(subject.getId());
        response.setName(subject.getName());
        return response;
    }
}
