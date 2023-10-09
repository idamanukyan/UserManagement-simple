package com.example.jetexpert.persistence;

import com.example.jetexpert.persistence.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdminRepository extends JpaRepository<Admin, UUID> {
}
