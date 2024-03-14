package da2.g35.tdtuconsultantbe.service;

import da2.g35.tdtuconsultantbe.dto.SubjectDTO;
import da2.g35.tdtuconsultantbe.entity.Subject;

import java.util.List;

public interface SubjectService {
    List<SubjectDTO.SubjectResponse> getSubjectsByCombination(Long id);
}
