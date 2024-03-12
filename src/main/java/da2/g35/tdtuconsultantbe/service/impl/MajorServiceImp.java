package da2.g35.tdtuconsultantbe.service.impl;

import da2.g35.tdtuconsultantbe.entity.Combination;
import da2.g35.tdtuconsultantbe.entity.Hobby;
import da2.g35.tdtuconsultantbe.entity.Major;
import da2.g35.tdtuconsultantbe.entity.User;
import da2.g35.tdtuconsultantbe.repository.CombinationRepository;
import da2.g35.tdtuconsultantbe.repository.HobbyRepository;
import da2.g35.tdtuconsultantbe.repository.MajorRepository;
import da2.g35.tdtuconsultantbe.repository.UserRepository;
import da2.g35.tdtuconsultantbe.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorServiceImp implements MajorService {
    @Autowired
    private MajorRepository majorRepository;
    @Autowired
    private CombinationRepository combinationRepository;
    @Autowired
    private HobbyRepository hobbyRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<Major> getAllMajors() {
        return null;
    }

    @Override
    public List<Major> getMajorsByFaculty(Long id) {
        return majorRepository.getMajorsByFaculty_Id(id);
    }

    @Override
    public List<Major> getMajorsByCombination(Long id) {
        return majorRepository.findByMajorCombinations(combinationRepository.findById(id).get());
    }

    @Override
    public List<Major> getMajorsByHobby(Long id) {
        return majorRepository.findByMajorHobbies(hobbyRepository.findById(id).get());
    }

    @Override
    public List<Major> getMajorsByUser(Long id) {
        return majorRepository.findByWhoseMajors(userRepository.findById(id).get());
    }
}
