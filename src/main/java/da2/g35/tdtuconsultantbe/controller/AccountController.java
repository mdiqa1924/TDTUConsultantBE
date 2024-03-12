package da2.g35.tdtuconsultantbe.controller;

import da2.g35.tdtuconsultantbe.dto.AccountDTO;
import da2.g35.tdtuconsultantbe.entity.Account;
import da2.g35.tdtuconsultantbe.entity.Transcript;
import da2.g35.tdtuconsultantbe.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping(value = "/register")
    public ResponseEntity<Object> register(@Valid @RequestBody AccountDTO.RegisterForm registerForm){
        Transcript newAccount = accountService.create(registerForm);
        return ResponseEntity.ok().body(newAccount);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<Object> login(@Valid @RequestBody AccountDTO.LoginForm loginForm){
        Transcript response = accountService.validateLogin(loginForm);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/changePassword", produces = "application/json")
    public ResponseEntity<Object> changePassword(@Valid @RequestBody AccountDTO.ChangePasswordForm changePasswordForm){
        accountService.changePassword(changePasswordForm);
        return ResponseEntity.ok().body("{\"message\": \"Change password successfully!\"}");
    }

    @PostMapping(value = "/sendVerificationEmail", produces = "application/json")
    public ResponseEntity<Object> sendVerificationEmail(@Valid @RequestBody String email){

    }

    @PostMapping(value = "/resetPassword", produces = "application/json")
    public ResponseEntity<Object> resetPassword(@Valid @RequestBody AccountDTO.ChangePasswordForm resetPasswordForm){
        return ResponseEntity.ok().body("{\"message\": \"Reset password successfully!\"}");
    }
}
