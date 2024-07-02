package com.villatech.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

//Add your annotations here
@Data
@Entity
public class User {

    @Id
    private String userName;
    private String name;
    private  String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLe",
        joinColumns = {
                @JoinColumn(name = "USER_ID")
        },
        inverseJoinColumns = {
                @JoinColumn(name = "ROLE_ID")
        }
    )
    private Set<Role> role;

}
