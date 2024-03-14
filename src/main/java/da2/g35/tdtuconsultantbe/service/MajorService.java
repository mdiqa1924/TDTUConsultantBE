package da2.g35.tdtuconsultantbe.service;

import da2.g35.tdtuconsultantbe.dto.CombinationDTO;
import da2.g35.tdtuconsultantbe.dto.MajorDTO;
import da2.g35.tdtuconsultantbe.entity.Combination;
import da2.g35.tdtuconsultantbe.entity.Hobby;
import da2.g35.tdtuconsultantbe.entity.Major;
import da2.g35.tdtuconsultantbe.entity.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MajorService {
    List<MajorDTO.MajorResponse> getAllMajors();
    MajorDTO.MajorResponse getMajorById(Long id);
    List<MajorDTO.MajorResponse> getMajorsByFaculty(Long id);
    List<MajorDTO.MajorResponse> getMajorsByHobby(Long id);
    List<MajorDTO.MajorResponse> getMajorsByCombination(Long id);
    List<MajorDTO.MajorResponse> getMajorsByUser(Long id);
    //for prediction
//    List<MajorDTO.MajorResponse> getMajorsByCombinations(List<Combination> combinations);
}
