package da2.g35.tdtuconsultantbe.service;

import da2.g35.tdtuconsultantbe.dto.AccountDTO;
import da2.g35.tdtuconsultantbe.dto.UserDTO;
import da2.g35.tdtuconsultantbe.entity.User;

public interface UserService {
    User getUserProfile(Long id);
    User update(Long id, UserDTO.updateUserForm updateUserForm);
}
