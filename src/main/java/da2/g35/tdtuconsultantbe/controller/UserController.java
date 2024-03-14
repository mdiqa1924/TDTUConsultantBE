package da2.g35.tdtuconsultantbe.controller;

import da2.g35.tdtuconsultantbe.dto.UserDTO;
import da2.g35.tdtuconsultantbe.entity.User;
import da2.g35.tdtuconsultantbe.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getUserProfile(@Valid @PathVariable Long id){
        UserDTO.userResponse user = userService.getUserProfile(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<Object> update(@Valid @PathVariable Long id, @RequestBody UserDTO.updateUserForm updateUserForm){
        UserDTO.userResponse user = userService.update(id, updateUserForm);
        return ResponseEntity.ok(user);
    }
}
