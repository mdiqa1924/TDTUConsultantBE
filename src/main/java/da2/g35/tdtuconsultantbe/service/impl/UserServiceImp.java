package da2.g35.tdtuconsultantbe.service.impl;

import da2.g35.tdtuconsultantbe.dto.AccountDTO;
import da2.g35.tdtuconsultantbe.dto.UserDTO;
import da2.g35.tdtuconsultantbe.entity.Account;
import da2.g35.tdtuconsultantbe.entity.User;
import da2.g35.tdtuconsultantbe.repository.AccountRepository;
import da2.g35.tdtuconsultantbe.repository.UserRepository;
import da2.g35.tdtuconsultantbe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImp implements UserService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserProfile(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User update(Long id, UserDTO.updateUserForm updateUserForm) {
        User user = userRepository.findById(id).get();
        user.setFullname(updateUserForm.getFullname());
        user.setPhoneNumber(updateUserForm.getPhoneNumber());
        user.setSchool(updateUserForm.getSchool());
        user.setDob(updateUserForm.getDob());

        User result = userRepository.save(user);
        return result;
    }
}
