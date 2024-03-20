package da2.g35.tdtuconsultantbe.service.impl;

import da2.g35.tdtuconsultantbe.dto.HobbyDTO;
import da2.g35.tdtuconsultantbe.dto.MajorDTO;
import da2.g35.tdtuconsultantbe.entity.Hobby;
import da2.g35.tdtuconsultantbe.entity.Major;
import da2.g35.tdtuconsultantbe.entity.TestUser;
import da2.g35.tdtuconsultantbe.entity.User;
import da2.g35.tdtuconsultantbe.repository.HobbyRepository;
import da2.g35.tdtuconsultantbe.repository.MajorRepository;
import da2.g35.tdtuconsultantbe.repository.TestUserRepository;
import da2.g35.tdtuconsultantbe.repository.UserRepository;
import da2.g35.tdtuconsultantbe.service.HobbyService;
import da2.g35.tdtuconsultantbe.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HobbyServiceImp implements HobbyService {
    @Autowired
    private HobbyRepository hobbyRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TestUserRepository testUserRepository;
    @Autowired
    private MajorService majorService;


    @Override
    public HobbyDTO.MBTITestResponse testResponse(HobbyDTO.MBTITestResult result) {
        Hobby hobby = hobbyRepository.findByCode(result.getResult());
        HobbyDTO.MBTITestResponse response = new HobbyDTO.MBTITestResponse();
        TestUser testUser = new TestUser();
        testUser.setEmail(result.getEmail());
        testUserRepository.save(testUser);
        List<String> majorsResponse = new ArrayList<>();
        List<MajorDTO.MajorResponse> majors = majorService.getMajorsByHobby(hobby.getId());
        for(MajorDTO.MajorResponse m:majors){
            majorsResponse.add(m.getName());
        }
        response.setName(hobby.getName());
        response.setDescription(hobby.getDescription());
        response.setMajors(majorsResponse);
        return response;
    }

    @Override
    public List<HobbyDTO.HobbyResponse> getHobbiesByUser(Long id) {
        List<HobbyDTO.HobbyResponse> responses = new ArrayList<>();
        List<Hobby> hobbies = hobbyRepository.findHobbiesByWhoseHobbiesContains(userRepository.findById(id).get());
        for (Hobby h:hobbies){
            responses.add(formatHobbyResponse(h));
        }
        return responses;
    }

    public HobbyDTO.HobbyResponse formatHobbyResponse(Hobby hobby){
        HobbyDTO.HobbyResponse response = new HobbyDTO.HobbyResponse();
        response.setId(hobby.getId());
        response.setName(hobby.getName());
        response.setCode(hobby.getCode());
        response.setDescription(hobby.getDescription());
        return response;
    }
}
