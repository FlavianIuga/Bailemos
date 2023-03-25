package com.bailemos.event;

import com.bailemos.dto.ActivityResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
@Log4j2
public class EventService {

  private final EventRepository eventRepository;
  private final WebClient webClient;
  ObjectMapper mapper = new ObjectMapper();

  public void createEvent(EventRequest eventRequest) {
    Event event = Event.builder()
        .userId(eventRequest.getUserId())
        .eventType(eventRequest.getEventType())
        .name(eventRequest.getName())
        .description(eventRequest.getDescription())
        .startDate(eventRequest.getStartDate())
        .endDate(eventRequest.getEndDate())
        .build();

    eventRepository.save(event);
  }

  public EventResponse getEvent(Long eventId) {
    Event event = eventRepository.findById(eventId).orElseThrow();
    return mapToEventResponse(event);
  }

  public List<EventResponse> getAllEvents() {
    List<Event> events = eventRepository.findAll();
    return events.stream().map(this::mapToEventResponse).toList();
  }

  public List<Long> getUsersInAttendance(Long eventId) {
    //TODO get activity id's from activity microservice

    Object[] eventActivities = webClient.get()
        .uri("http://localhost:8083/api/activity?eventId=" + eventId)
        .retrieve()
        .bodyToMono(Object[].class)
        .block();

    List<ActivityResponse> activities = Arrays.stream(eventActivities)
        .map(object -> mapper.convertValue(object, ActivityResponse.class)).toList();

    //TODO for each activity get participating user id's from attendance microservice
    //TODO return list of user id's

    return null;
  }

  private EventResponse mapToEventResponse(Event event) {
    return EventResponse.builder()
        .id(event.getId())
        .name(event.getName())
        .description(event.getDescription())
        .userId(event.getUserId())
        .eventType(event.getEventType())
        .startDate(event.getStartDate())
        .build();
  }

}
