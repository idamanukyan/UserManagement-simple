package com.example.jetexpert.api;

import com.example.jetexpert.persistence.AdminRepository;
import com.example.jetexpert.persistence.UserRepository;
import com.example.jetexpert.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminRepository adminRepository;

    @PostMapping("/approve/{userId}")
    public ResponseEntity<String> approveUser(@PathVariable UUID userId) {

        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            user.setApproved(true);
            userRepository.save(user);
            return ResponseEntity.ok("User is approved.");
        }

        return ResponseEntity.badRequest().body("User is not approved.");
    }

    @PostMapping("/reject/{userId}")
    public ResponseEntity<String> rejectUser(@PathVariable UUID userId) {

        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            user.setApproved(false);
            userRepository.save(user);
            return ResponseEntity.ok("User is rejected.");
        }
        return ResponseEntity.badRequest().body("User is not rejected.");
    }

}
