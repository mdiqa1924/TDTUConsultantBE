package da2.g35.tdtuconsultantbe.service.impl;

import da2.g35.tdtuconsultantbe.entity.Hobby;
import da2.g35.tdtuconsultantbe.repository.HobbyRepository;
import da2.g35.tdtuconsultantbe.repository.MajorRepository;
import da2.g35.tdtuconsultantbe.repository.UserRepository;
import da2.g35.tdtuconsultantbe.service.HobbyService;
import da2.g35.tdtuconsultantbe.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HobbyServiceImp implements HobbyService {
    @Autowired
    private HobbyRepository hobbyRepository;
    @Autowired
    private MajorRepository majorRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Hobby> getHobbiesByMajor(Long id) {
        return hobbyRepository.findByMajorByHobby(majorRepository.findById(id).get());
    }

    @Override
    public List<Hobby> getHobbiesByUser(Long id) {
        return hobbyRepository.findByWhoseHobbies(userRepository.findById(id).get());
    }
}
