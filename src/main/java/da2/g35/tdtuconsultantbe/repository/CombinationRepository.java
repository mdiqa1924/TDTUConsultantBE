package da2.g35.tdtuconsultantbe.repository;

import da2.g35.tdtuconsultantbe.entity.Combination;
import da2.g35.tdtuconsultantbe.entity.Major;
import da2.g35.tdtuconsultantbe.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CombinationRepository extends JpaRepository<Combination, Long> {
    List<Combination> findByCombinationSubjects(Subject subject);
    List<Combination> findByMajorByCombination(Major major);
    Combination findCombinationByCombinationSubjects(List<Subject> subjects);
}
