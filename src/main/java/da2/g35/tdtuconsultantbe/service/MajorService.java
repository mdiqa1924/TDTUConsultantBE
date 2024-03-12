package da2.g35.tdtuconsultantbe.service;

import da2.g35.tdtuconsultantbe.entity.Combination;
import da2.g35.tdtuconsultantbe.entity.Hobby;
import da2.g35.tdtuconsultantbe.entity.Major;
import da2.g35.tdtuconsultantbe.entity.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MajorService {
    List<Major> getAllMajors();


    List<Major> getMajorsByFaculty(Long id);
    List<Major> getMajorsByHobby(Long id);
    List<Major> getMajorsByCombination(Long id);
    List<Major> getMajorsByUser(Long id);
}
