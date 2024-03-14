package da2.g35.tdtuconsultantbe.service;

import da2.g35.tdtuconsultantbe.dto.UserDTO;
import da2.g35.tdtuconsultantbe.entity.User;

public interface UserService {
    UserDTO.userResponse getUserProfile(Long id);
    UserDTO.userResponse update(Long id, UserDTO.updateUserForm updateUserForm);
}
