package com.tweteroo.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.models.Tweet;
import com.tweteroo.api.models.Users;
import com.tweteroo.api.repositories.TweetRepository;
import com.tweteroo.api.repositories.UserRepository;

@Service
public class TweetService {

  @Autowired
  private TweetRepository repository;

  @Autowired
  private UserRepository userRepository;

  public Page<Tweet> listTweets(int page) {
    Pageable pageable = PageRequest.of(page, 5);
    return repository.findAll(pageable);
  }

  public void create(TweetDTO req){
    List<Users> user = userRepository.findByUsername(req.username());
    if(user.isEmpty()) throw new Error("User not found");
    repository.save(new Tweet(req, user.get(0).getAvatar()));
  }

  public List<Tweet> getTweetsByUsername(String username) {
    return repository.findByUsername(username);
  }
}
