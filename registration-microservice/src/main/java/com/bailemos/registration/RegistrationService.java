package com.bailemos.registration;

import com.bailemos.dto.RegistrationRequest;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class RegistrationService {

  private RegistrationRepository registrationRepository;

  public void createRegistration(RegistrationRequest registrationRequest) {
    Registration registration = Registration.builder()
        .userId(registrationRequest.getUserId())
        .eventId(registrationRequest.getEventId())
        .entryDate(new Date())
        .registrationStatus(RegistrationStatus.ENTERED)
        .build();

    registrationRepository.save(registration);
  }

}
