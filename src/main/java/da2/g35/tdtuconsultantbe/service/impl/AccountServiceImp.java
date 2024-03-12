package da2.g35.tdtuconsultantbe.service.impl;

import da2.g35.tdtuconsultantbe.dto.AccountDTO;
import da2.g35.tdtuconsultantbe.entity.Account;
import da2.g35.tdtuconsultantbe.entity.Transcript;
import da2.g35.tdtuconsultantbe.entity.User;
import da2.g35.tdtuconsultantbe.repository.AccountRepository;
import da2.g35.tdtuconsultantbe.repository.PasswordTokenRepository;
import da2.g35.tdtuconsultantbe.repository.TranscriptRepository;
import da2.g35.tdtuconsultantbe.repository.UserRepository;
import da2.g35.tdtuconsultantbe.service.AccountService;
import da2.g35.tdtuconsultantbe.service.TranscriptService;
import da2.g35.tdtuconsultantbe.service.UserService;
import da2.g35.tdtuconsultantbe.util.forPassword.PasswordResetToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.io.Console;
import java.util.UUID;

@Service
public class AccountServiceImp implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TranscriptRepository transcriptRepository;
    @Autowired
    private PasswordTokenRepository passwordTokenRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private TranscriptService transcriptService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username")
    private String sender;


    @Override
    public Account getByEmail(String email) {
        return accountRepository.findByEmail(email).get();
    }

    @Override
    public Transcript validateLogin(AccountDTO.LoginForm loginForm) {

        if(accountRepository.findByEmail(loginForm.getEmail()).isEmpty()){
            throw new RuntimeException("Email is not registered yet.");
        }
        else {
            Account checkAccount = accountRepository.findByEmail(loginForm.getEmail()).get();
            if(passwordEncoder.matches(loginForm.getPassword(), checkAccount.getPassword())){

//                AccountDTO.LoginSuccessResponse response = new AccountDTO.LoginSuccessResponse();
//                response.setEmail(checkAccount.getEmail());
//                response.setUser(userRepository.findById(checkAccount.getId()).get());
//                response.setTranscript(transcriptRepository.findById(checkAccount.getId()).get());
                return transcriptRepository.findById(checkAccount.getId()).get();
            }
            else {
                throw new RuntimeException("Password is wrong.");
            }
        }
    }

    @Override
    public Transcript create(AccountDTO.RegisterForm registerForm) {
        accountRepository.findByEmail(registerForm.getEmail()).ifPresent(account -> {
            throw new RuntimeException("Email already exists.");
        });
        Account newAccount = new Account();
        newAccount.setEmail(registerForm.getEmail());
        newAccount.setPassword(passwordEncoder.encode(registerForm.getPassword()) );

        User newUser = new User();
        newUser.setFullname(registerForm.getFullname());
        newUser.setPhoneNumber(registerForm.getPhoneNumber());
        newUser.setDob(registerForm.getDob());
        newUser.setSchool(registerForm.getSchool());
        newUser.setAccount(newAccount);
        newAccount.setUser(newUser);
        userRepository.save(newUser);

        Transcript newTranscript = new Transcript();
        newTranscript.setUser(newUser);
        newUser.setTranscript(newTranscript);
        transcriptRepository.save(newTranscript);

        accountRepository.save(newAccount);

//        AccountDTO.RegisterResponse response = new AccountDTO.RegisterResponse();
//        response.setAccount(newAccount);
//        response.setUser(newUser);
//        response.setTranscript(newTranscript);


        return newTranscript;
    }

    @Override
    public void delete(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Account changePassword(AccountDTO.ChangePasswordForm changePasswordForm) {
        Account account = accountRepository.findByEmail(changePasswordForm.getEmail()).get();
        if(account == null){
            throw new RuntimeException("Account doesn't exist.");
        }
        else {
            if(!passwordEncoder.matches(changePasswordForm.getCurrentPassword(), account.getPassword())){
                throw new RuntimeException("Password doesn't match.");
            }
            account.setPassword(passwordEncoder.encode(changePasswordForm.getNewPassword()));
            Account result = accountRepository.save(account);
            return result;
        }
    }

    @Override
    public Account resetPassword(AccountDTO.ChangePasswordForm changePasswordForm) {
        return null;
    }

    @Override
    public AccountDTO.EmailResponse sendResetPasswordEmail(String email) {
        Account account = accountRepository.findByEmail(email).get();
        if(account == null){
            throw new RuntimeException("Account Not Found.");
        }
        String token = UUID.randomUUID().toString();
        createPasswordResetToken(account, token);
        sendEmail(email, "Reset Password", "Your verification code is: " + token);

        return new AccountDTO.EmailResponse(true, "Send reset email succesfully!");
    }

    public void createPasswordResetToken(Account account, String token){
        PasswordResetToken resetToken = new PasswordResetToken();
        resetToken.setToken(token);
        resetToken.setAccount(account);
        passwordTokenRepository.save(resetToken);
    }

    @Override
    public AccountDTO.EmailResponse sendEmail(String email, String subject, String content) {
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(sender);
            message.setTo(email);
            message.setSubject(subject);
            message.setText(content);
            javaMailSender.send(message);
            return new AccountDTO.EmailResponse(true, "Email");
        }
        catch (Exception e){
            e.printStackTrace();
            return new AccountDTO.EmailResponse(false, "Fail to send email: " + e.getMessage());
        }

    }


}
