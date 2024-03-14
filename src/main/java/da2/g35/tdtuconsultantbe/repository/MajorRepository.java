package da2.g35.tdtuconsultantbe.repository;

import da2.g35.tdtuconsultantbe.dto.MajorDTO;
import da2.g35.tdtuconsultantbe.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Repository
public interface MajorRepository extends JpaRepository<Major, Long> {

    List<Major> findMajorsByFaculty(Faculty faculty);
    List<Major> findMajorsByMajorCombinationsContains(Combination combination);
    List<Major> findMajorsByWhoseMajorsContains(User user);

}
