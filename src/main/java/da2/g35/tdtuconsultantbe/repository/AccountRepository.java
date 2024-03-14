package da2.g35.tdtuconsultantbe.repository;
import da2.g35.tdtuconsultantbe.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
    Account findByEmail(String email);
}
