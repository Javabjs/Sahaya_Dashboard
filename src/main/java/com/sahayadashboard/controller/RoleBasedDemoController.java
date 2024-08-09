package com.sahayadashboard.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class RoleBasedDemoController {
    @GetMapping("/admin")
    public ResponseEntity<String> admin() {
        return new ResponseEntity<>("This is admin", HttpStatus.OK);
    }
    @GetMapping("/user")
    public ResponseEntity<String> user() {
        return new ResponseEntity<>("This is user", HttpStatus.OK);
    }

}

