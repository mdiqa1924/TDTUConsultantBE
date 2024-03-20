package da2.g35.tdtuconsultantbe.service;

import da2.g35.tdtuconsultantbe.dto.HobbyDTO;
import da2.g35.tdtuconsultantbe.entity.Hobby;

import java.util.List;

public interface HobbyService {
    HobbyDTO.MBTITestResponse testResponse(HobbyDTO.MBTITestResult result);
    List<HobbyDTO.HobbyResponse> getHobbiesByUser(Long id);
}
