package com.nulp.bat.travelagency.controller;

import com.nulp.bat.travelagency.dto.TokenDTO;
import com.nulp.bat.travelagency.model.AuthRequest;
import com.nulp.bat.travelagency.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class WelcomeController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String welcome() {
        return "Welcome to  !!";
    }

//    @GetMapping("/hello")
//    public String hello() {
//        return "hello dear friend";
//    }
//
//    @GetMapping("/user")
//    public String user() {
//        return "hello dear user";
//    }
//
//    @GetMapping("/admin")
//    public String admin() {
//        return "hello dear admin";
//    }



    @PostMapping("/login")  //signin
    public TokenDTO generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserLogin(), authRequest.getUserPassword())
            );
        } catch (Exception ex) {
            throw new Exception("invalid login/ password");
        }

        return new TokenDTO(jwtUtil.generateToken(authRequest.getUserLogin()));
    }

}
