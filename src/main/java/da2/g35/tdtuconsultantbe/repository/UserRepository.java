package da2.g35.tdtuconsultantbe.repository;

import da2.g35.tdtuconsultantbe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
