package da2.g35.tdtuconsultantbe.service;

import da2.g35.tdtuconsultantbe.dto.CombinationDTO;
import da2.g35.tdtuconsultantbe.entity.Combination;
import da2.g35.tdtuconsultantbe.entity.Subject;

import java.util.List;

public interface CombinationService {
    CombinationDTO.CombinationResponse getCombinationById(Long id);
    List<CombinationDTO.CombinationResponse> getCombinationsByMajor(Long id);
    //for prediction
    List<CombinationDTO.CombinationResponse> getCombinationsBySubject(Long id);
}
