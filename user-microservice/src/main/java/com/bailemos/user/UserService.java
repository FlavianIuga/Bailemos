package com.bailemos.user;

import java.util.List;
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
        .externalProfiles(userRequest.getExternalProfiles())
        .build();

    userRepository.save(user);
    log.info("User " + user.getId() + " created.");
  }

  public UserResponse getUser(Long userId) {
    User user = userRepository.findById(userId).orElseThrow();
    return mapToUserResponse(user);
  }

  public List<UserResponse> getUsers() {
    List<User> users = userRepository.findAll();
    return users.stream().map(this::mapToUserResponse).toList();
  }

  private UserResponse mapToUserResponse(User user) {
    return UserResponse.builder()
        .id(user.getId())
        .handle(user.getHandle())
        .name(user.getName())
        .description(user.getDescription())
        .email(user.getEmail())
        .dateOfBirth(user.getDateOfBirth())
        .location(user.getLocation())
        .externalProfiles(user.getExternalProfiles())
        .build();
  }
}
