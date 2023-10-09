package com.example.jetexpert.security;

import com.example.jetexpert.persistence.AdminRepository;
import com.example.jetexpert.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;
    private final AdminRepository adminRepository;

    @Autowired
    public UserDetailsService(UserRepository userRepository, AdminRepository adminRepository) {
        this.userRepository = userRepository;
        this.adminRepository = adminRepository;

    }
}
