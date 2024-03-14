package da2.g35.tdtuconsultantbe.service;

import da2.g35.tdtuconsultantbe.dto.FacultyDTO;
import da2.g35.tdtuconsultantbe.entity.Faculty;

import java.util.List;

public interface FacultyService {
    List<FacultyDTO.FacultyResponse> getListFaculty();
    FacultyDTO.FacultyResponse getFacultyByMajor(Long id);
    FacultyDTO.FacultyResponse getFacultyById(Long id);
}
