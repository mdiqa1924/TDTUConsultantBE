package da2.g35.tdtuconsultantbe.service;

import da2.g35.tdtuconsultantbe.dto.AccountDTO;
import da2.g35.tdtuconsultantbe.entity.Account;
import da2.g35.tdtuconsultantbe.entity.Transcript;

public interface AccountService {
    Account getByEmail(String email);
    Transcript create(AccountDTO.RegisterForm registerForm);
    Transcript validateLogin(AccountDTO.LoginForm loginForm);
    void delete(Long id);
    Account changePassword(AccountDTO.ChangePasswordForm changePasswordForm);
    Account resetPassword(AccountDTO.ChangePasswordForm changePasswordForm);
    AccountDTO.EmailResponse sendResetPasswordEmail(String email);
    AccountDTO.EmailResponse sendEmail(String email, String subject, String content);
}
