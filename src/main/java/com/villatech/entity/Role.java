package com.villatech.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

//Add your annotations here
@Entity
@Data
public class Role {

    @Id
    private String roleName;
    private String roleDescription;
}
