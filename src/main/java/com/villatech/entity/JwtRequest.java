package com.villatech.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Add your annotations here
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtRequest {

    private String userName;
    private String password;

}
