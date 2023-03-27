package com.bailemos.registration;

import com.bailemos.dto.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/registration")
@RequiredArgsConstructor
public class RegistrationController {

  private final RegistrationService registrationService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void createRegistration(@RequestBody RegistrationRequest registrationRequest){
    registrationService.createRegistration(registrationRequest);
  }
}
