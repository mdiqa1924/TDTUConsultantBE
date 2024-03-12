package da2.g35.tdtuconsultantbe.service;

import da2.g35.tdtuconsultantbe.entity.Faculty;

import java.util.List;

public interface FacultyService {
    List<Faculty> getListFaculty();
    Faculty getFacultyByMajor(Long id);
}
