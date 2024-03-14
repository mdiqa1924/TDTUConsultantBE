package da2.g35.tdtuconsultantbe.repository;

import da2.g35.tdtuconsultantbe.entity.Account;
import da2.g35.tdtuconsultantbe.entity.Faculty;
import da2.g35.tdtuconsultantbe.entity.Hobby;
import da2.g35.tdtuconsultantbe.entity.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Faculty findByMajors(Major major);
    List<Faculty> findFacultiesByHobbyByFacultyContains(Hobby hobby);
}
