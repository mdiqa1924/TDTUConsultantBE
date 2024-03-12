package da2.g35.tdtuconsultantbe.dto;

import da2.g35.tdtuconsultantbe.entity.Account;
import da2.g35.tdtuconsultantbe.entity.Transcript;
import da2.g35.tdtuconsultantbe.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class AccountDTO {

    @Data
    @AllArgsConstructor
    public static class LoginForm{
        private String email;
        private String password;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LoginSuccessResponse{
        private String email;
        private User user;
        private Transcript transcript;
    }

    @Data
    @AllArgsConstructor
    public static class RegisterForm {
        private String email;
        private String password;
        private String fullname;
        private String phoneNumber;
        private String dob;
        private String school;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RegisterResponse{
        private Account account;
        private User user;
        private Transcript transcript;
    }

    @Data
    @AllArgsConstructor
    public static class ChangePasswordForm{
        private String email;
        private String currentPassword;
        private String newPassword;
        private String verificationCode;
    }

    @Data
    @AllArgsConstructor
    public static class EmailResponse{
        private boolean isSuccess;
        private String message;
    }
}
