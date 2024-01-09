package com.jpoint.demoshop.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @GetMapping("/")
    public ResponseEntity<?> findItems() {
        return ResponseEntity.ok("It works!");
    }
}
