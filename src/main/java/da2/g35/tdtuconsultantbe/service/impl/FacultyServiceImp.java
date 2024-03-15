package da2.g35.tdtuconsultantbe.service.impl;

import da2.g35.tdtuconsultantbe.dto.FacultyDTO;
import da2.g35.tdtuconsultantbe.entity.Faculty;
import da2.g35.tdtuconsultantbe.entity.Major;
import da2.g35.tdtuconsultantbe.repository.FacultyRepository;
import da2.g35.tdtuconsultantbe.repository.MajorRepository;
import da2.g35.tdtuconsultantbe.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacultyServiceImp implements FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private MajorRepository majorRepository;
    @Override
    public List<FacultyDTO.FacultyResponse> getListFaculty() {
        List<Faculty> faculties = facultyRepository.findAll();
        List<FacultyDTO.FacultyResponse> responseList = new ArrayList<>();
        FacultyDTO.FacultyResponse facultyResponse = new FacultyDTO.FacultyResponse();
        for(Faculty f:faculties){
            facultyResponse = formatToResponse(f);
            responseList.add(facultyResponse);
        }
        return responseList;
    }

    @Override
    public FacultyDTO.FacultyResponse getFacultyByMajor(Long id) {
        Faculty faculty = facultyRepository.findByMajors(majorRepository.findById(id).get());
        FacultyDTO.FacultyResponse response = new FacultyDTO.FacultyResponse();
        response.setId(faculty.getId());
        response.setName(faculty.getName());
        response.setFound(faculty.getFound());
        response.setUrl(faculty.getUrl());
        return response;
    }

    @Override
    public FacultyDTO.FacultyResponse getFacultyById(Long id) {
        Faculty faculty = facultyRepository.findById(id).get();
        FacultyDTO.FacultyResponse response = formatToResponse(faculty);
        return response;
    }

    public FacultyDTO.FacultyResponse formatToResponse(Faculty faculty){
        FacultyDTO.FacultyResponse response = new FacultyDTO.FacultyResponse();
        response.setId(faculty.getId());
        response.setName(faculty.getName());
        response.setFound(faculty.getFound());
        response.setUrl(faculty.getUrl());
        response.setImg(faculty.getImg());
        return response;
    }
}
