package com.gopal.controllers;

import com.gopal.dto.HelloResponse;
import com.gopal.entities.Role;
import com.gopal.services.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AuthService authService;

    @GetMapping("/hello")
    public HelloResponse hello() {
        String msg = "Hello from Authorized API request.";
        logger.info("coming - {}", msg);
        return new HelloResponse(msg);
    }

    @GetMapping("/get-roles")
    public ResponseEntity<?> getRoles(Authentication authentication) throws Exception{
        if(authentication.getAuthorities().contains("admin")) {
            return new ResponseEntity<>(authService.getRoles(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(authService.getRoles(), HttpStatus.OK);
            //throw new Exception("Unauthorized");
        }
    }

    @GetMapping("/save-navigation")
    public HelloResponse test(@RequestBody String name) {
        String msg = "Hello from Authorized API request. - " + name;
        logger.info("name - {}", name);
        return new HelloResponse(msg);
    }

}
