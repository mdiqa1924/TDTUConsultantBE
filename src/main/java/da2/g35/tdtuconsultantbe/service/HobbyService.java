package da2.g35.tdtuconsultantbe.service;

import da2.g35.tdtuconsultantbe.entity.Hobby;

import java.util.List;

public interface HobbyService {
    List<Hobby> getHobbiesByMajor(Long id);
    List<Hobby> getHobbiesByUser(Long id);
}
