package com.tweteroo.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tweteroo.api.models.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
  List<Users> findByUsername(String username);
}
