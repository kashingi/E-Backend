package com.villatech.controller;

import com.villatech.entity.JwtRequest;
import com.villatech.entity.JwtResponse;
import com.villatech.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//Add your annotations here
@RestController
@CrossOrigin
@RequestMapping(path = "/api/v1")
public class JwtController {

    @Autowired
    private JwtService jwtService;

    @PostMapping(path = "/authenticate")
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return jwtService.createJwtToken(jwtRequest);
    }
}
