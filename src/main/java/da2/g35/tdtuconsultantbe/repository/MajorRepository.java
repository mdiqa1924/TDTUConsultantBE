package da2.g35.tdtuconsultantbe.repository;

import da2.g35.tdtuconsultantbe.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface MajorRepository extends JpaRepository<Major, Long> {

    List<Major> getMajorsByFaculty_Id(Long id);
    List<Major> findByMajorHobbies(Hobby hobby);
    List<Major> findByMajorCombinations(Combination combination);
    List<Major> findByWhoseMajors(User user);

}
