package da2.g35.tdtuconsultantbe.service.impl;

import da2.g35.tdtuconsultantbe.entity.Faculty;
import da2.g35.tdtuconsultantbe.entity.Major;
import da2.g35.tdtuconsultantbe.repository.FacultyRepository;
import da2.g35.tdtuconsultantbe.repository.MajorRepository;
import da2.g35.tdtuconsultantbe.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImp implements FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private MajorRepository majorRepository;
    @Override
    public List<Faculty> getListFaculty() {
        List<Faculty> faculties = facultyRepository.findAll();
        return faculties;
    }

    @Override
    public Faculty getFacultyByMajor(Long id) {
        return facultyRepository.findByMajors(majorRepository.findById(id).get());
    }
}
