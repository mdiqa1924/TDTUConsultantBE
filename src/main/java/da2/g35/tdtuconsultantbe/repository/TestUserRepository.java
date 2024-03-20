package da2.g35.tdtuconsultantbe.repository;

import da2.g35.tdtuconsultantbe.entity.TestUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestUserRepository extends JpaRepository<TestUser, Long> {

}
