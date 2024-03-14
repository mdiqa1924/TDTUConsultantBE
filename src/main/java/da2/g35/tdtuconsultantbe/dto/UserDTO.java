package da2.g35.tdtuconsultantbe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class UserDTO {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class userResponse {
        private Long id;
        private String fullname;
        private String phoneNumber;
        private String dob;
        private String school;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class updateUserForm {
        private String fullname;
        private String phoneNumber;
        private String dob;
        private String school;
    }
}
