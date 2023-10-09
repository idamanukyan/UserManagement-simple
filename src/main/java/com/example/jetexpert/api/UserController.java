package com.example.jetexpert.api;

import com.example.jetexpert.dto.UserDTO;
import com.example.jetexpert.persistence.UserRepository;
import com.example.jetexpert.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable UUID id, Model model) {
        User user = userRepository.findById(id).orElse(null);
        return convertToUserDTO(user);
    }

    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable UUID id, @RequestBody UserDTO updatedUserDTO) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setEmail(updatedUserDTO.getEmail());
            user.setFirstName(updatedUserDTO.getFirstName());
            user.setLastName(updatedUserDTO.getLastName());
            user.setAge(updatedUserDTO.getAge());
            user.setApproved(updatedUserDTO.isApproved());
            userRepository.save(user);
        }
        return convertToUserDTO(user);
    }

    private UserDTO convertToUserDTO(User user) {
        if (user == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setAge(user.getAge());
        userDTO.setApproved(user.isApproved());
        return userDTO;
    }
}
