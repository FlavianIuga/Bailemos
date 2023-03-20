package com.bailemos.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserService {

  private final UserRepository userRepository;

  public void createUser(UserRequest userRequest) {
    User user = User.builder()
        .handle(userRequest.getHandle())
        .name(userRequest.getName())
        .description(userRequest.getDescription())
        .email(userRequest.getEmail())
        .dateOfBirth(userRequest.getDateOfBirth())
        .location(userRequest.getLocation())
        .danceTypes(userRequest.getDanceTypes())
//        .externalProfiles(userRequest.getExternalProfiles())
        .roles(userRequest.getRoles()).build();

    userRepository.save(user);
    log.info("User " + user.getId() + " created.");
  }
}
