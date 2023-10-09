package com.example.jetexpert.persistence.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "admins")
@Data
public class Admin {

    private UUID id;
    private String email;
    private String firstName;
    private String lastName;
    private Role role;
}
