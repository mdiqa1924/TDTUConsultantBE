package da2.g35.tdtuconsultantbe.service.impl;

import da2.g35.tdtuconsultantbe.dto.FacultyDTO;
import da2.g35.tdtuconsultantbe.dto.MajorDTO;
import da2.g35.tdtuconsultantbe.entity.*;
import da2.g35.tdtuconsultantbe.repository.*;
import da2.g35.tdtuconsultantbe.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MajorServiceImp implements MajorService {
    @Autowired
    private MajorRepository majorRepository;
    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private CombinationRepository combinationRepository;
    @Autowired
    private HobbyRepository hobbyRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<MajorDTO.MajorResponse> getAllMajors() {
        List<Major> majors = majorRepository.findAll();
        List<MajorDTO.MajorResponse> responseList = new ArrayList<>();
        MajorDTO.MajorResponse majorResponse = new MajorDTO.MajorResponse();
        for(Major m:majors){
            majorResponse = formatMajorResponse(m);
            responseList.add(majorResponse);
        }
        return responseList;
    }

    @Override
    public MajorDTO.MajorResponse getMajorById(Long id) {
        Major major = majorRepository.findById(id).get();
        MajorDTO.MajorResponse response = formatMajorResponse(major);
        return response;
    }

        @Override
    public List<MajorDTO.MajorResponse> getMajorsByFaculty(Long id) {
        List<Major> majors = majorRepository.findMajorsByFaculty(facultyRepository.findById(id).get());
        List<MajorDTO.MajorResponse> responses = new ArrayList<>();
        for(Major m:majors){
            responses.add(formatMajorResponse(m));
        }
        return responses;
    }

    @Override
    public List<MajorDTO.MajorResponse> getMajorsByCombination(Long id) {
        List<MajorDTO.MajorResponse> responses = new ArrayList<>();
        List<Major> majors = majorRepository.findMajorsByMajorCombinationsContains(combinationRepository.findById(id).get());
        for (Major m:majors){
            responses.add(formatMajorResponse(m));
        }
        return responses;
    }

    @Override
    public List<MajorDTO.MajorResponse> getMajorsByHobby(Long id) {
        List<MajorDTO.MajorResponse> responses = new ArrayList<>();
        List<Faculty> faculties = facultyRepository.findFacultiesByHobbyByFacultyContains(hobbyRepository.findById(id).get());
        for (Faculty f:faculties){
            List<Major> majors = majorRepository.findMajorsByFaculty(f);
            for (Major m:majors){
                responses.add(formatMajorResponse(m));
            }
        }
        return responses;
    }

    @Override
    public List<MajorDTO.MajorResponse> getMajorsByUser(Long id) {
        List<MajorDTO.MajorResponse> responses = new ArrayList<>();
        List<Major> majors = majorRepository.findMajorsByWhoseMajorsContains(userRepository.findById(id).get());
        for (Major m:majors){
            responses.add(formatMajorResponse(m));
        }
        return responses;
    }

    //for prediction
//    @Override
//    public List<MajorDTO.MajorResponse> getMajorsByCombinations(List<Combination> combinations) {
//        List<MajorDTO.MajorResponse> responses = new ArrayList<>();
//        List<Major> majors = majorRepository.findMajorsByMajorCombinationsIn(combinations);
//        for (Major m:majors){
//            responses.add(formatMajorResponse(m));
//        }
//        return responses;
//    }

    public MajorDTO.MajorResponse formatMajorResponse(Major major){
        MajorDTO.MajorResponse response = new MajorDTO.MajorResponse();
        response.setId(major.getId());
        response.setName(major.getName());
        response.setCode(major.getCode());
        response.setImg(major.getImg());
        return response;
    }
}
