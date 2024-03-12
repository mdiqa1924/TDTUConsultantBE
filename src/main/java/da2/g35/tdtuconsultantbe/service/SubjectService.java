package da2.g35.tdtuconsultantbe.service;

import da2.g35.tdtuconsultantbe.entity.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> getSubjectsByCombination(Long id);
}
