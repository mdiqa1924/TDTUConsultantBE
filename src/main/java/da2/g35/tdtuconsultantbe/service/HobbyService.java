package da2.g35.tdtuconsultantbe.service;

import da2.g35.tdtuconsultantbe.dto.HobbyDTO;
import da2.g35.tdtuconsultantbe.entity.Hobby;

import java.util.List;

public interface HobbyService {

    List<HobbyDTO.HobbyResponse> getHobbiesByUser(Long id);
}
