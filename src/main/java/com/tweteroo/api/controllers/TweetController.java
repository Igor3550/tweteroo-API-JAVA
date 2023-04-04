package com.tweteroo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.models.Tweet;
import com.tweteroo.api.services.TweetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tweets")
@CrossOrigin("*")
public class TweetController {
  
  @Autowired
  private TweetService service;
  
  @GetMapping
  public Page<Tweet> listTweets(@RequestParam int page) {
    return service.listTweets(page);
  }

  @PostMapping
  @ResponseStatus(value = HttpStatus.CREATED)
  public String signUp(@RequestBody @Valid TweetDTO req) {
    service.create(req);
    return "Ok";
  }

  @GetMapping("/{username}")
  public List<Tweet> getTweetsByUsername(@PathVariable String username) {
    return service.getTweetsByUsername(username);
  }
}
