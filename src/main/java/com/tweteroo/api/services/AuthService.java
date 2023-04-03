package com.tweteroo.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.UserDTO;
import com.tweteroo.api.models.Users;
import com.tweteroo.api.repositories.UserRepository;

@Service
public class AuthService {

  @Autowired
  private UserRepository repository;
  
  public Users signUp(UserDTO req) {
    return repository.save(new Users(req));
  }

  public List<Users> listAll() {
    return repository.findAll();
  }
}
