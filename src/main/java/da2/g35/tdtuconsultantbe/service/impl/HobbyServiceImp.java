package da2.g35.tdtuconsultantbe.service.impl;

import da2.g35.tdtuconsultantbe.dto.HobbyDTO;
import da2.g35.tdtuconsultantbe.entity.Hobby;
import da2.g35.tdtuconsultantbe.entity.User;
import da2.g35.tdtuconsultantbe.repository.HobbyRepository;
import da2.g35.tdtuconsultantbe.repository.MajorRepository;
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
