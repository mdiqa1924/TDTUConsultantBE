package da2.g35.tdtuconsultantbe.repository;

import da2.g35.tdtuconsultantbe.util.forPassword.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordTokenRepository extends JpaRepository<PasswordResetToken, Long> {

}
