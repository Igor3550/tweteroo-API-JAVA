package com.tweteroo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.UserDTO;
import com.tweteroo.api.models.User;
import com.tweteroo.api.services.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth/sign-up")
public class AuthController {
  
  @Autowired
  private AuthService service;

  @PostMapping
  public void signUp(@RequestBody @Valid UserDTO req) {
    service.signUp(req);
  }

  @GetMapping
  public List<User> getAll() {
    return service.listAll();
  }
}