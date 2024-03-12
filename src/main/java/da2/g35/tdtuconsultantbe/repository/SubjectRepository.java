package da2.g35.tdtuconsultantbe.repository;

import da2.g35.tdtuconsultantbe.entity.Account;
import da2.g35.tdtuconsultantbe.entity.Combination;
import da2.g35.tdtuconsultantbe.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    List<Subject> findByCombinationBySubject(Combination combination);
    Subject findByName(String name);
}
