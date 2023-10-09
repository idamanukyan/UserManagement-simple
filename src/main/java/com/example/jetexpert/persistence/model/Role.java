package com.example.jetexpert.persistence.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "roles")
public class Role {

    private UUID id;
    private String name;
    private String description;
}
