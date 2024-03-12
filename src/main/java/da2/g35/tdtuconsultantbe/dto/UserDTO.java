package da2.g35.tdtuconsultantbe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

public class UserDTO {

    @Data
    @AllArgsConstructor
    public class updateUserForm{
        private Long id;
        private String fullname;
        private String phoneNumber;
        private String dob;
        private String school;
    }
}
