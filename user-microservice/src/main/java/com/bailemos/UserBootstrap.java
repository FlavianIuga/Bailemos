package com.bailemos;

import com.bailemos.user.User;
import com.bailemos.user.UserRepository;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserBootstrap implements CommandLineRunner {

  private final UserRepository userRepository;

  @Override
  public void run(String... args) {

    User u1 = new User(1L, "user1", "User 1", "Decription User 1", "abc@abc.com", new Date(),
        "Timisoara", null);
    User u2 = new User(2L, "user2", "User 2", "Decription User 2", "abc@abc.com", new Date(),
        "Timisoara", null);
    User u3 = new User(3L, "user3", "User 3", "Decription User 3", "abc@abc.com", new Date(),
        "Timisoara", null);
    userRepository.save(u1);
    userRepository.save(u2);
    userRepository.save(u3);
  }
}
