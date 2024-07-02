package com.villatech.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Add your annotations here
@AllArgsConstructor
@Data
@NoArgsConstructor
public class JwtResponse {
    private User user;
    private String jwtToken;
}
