package com.tweteroo.api.models;

import com.tweteroo.api.dto.TweetDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Tweet {

  public Tweet(TweetDTO req, String avatar) {
    this.username = req.username();
    this.text = req.text();
    this.avatar = avatar;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false)
  private String username;

  @Column(nullable = false)
  private String avatar;

  @Column(nullable = false)
  private String text;
}
