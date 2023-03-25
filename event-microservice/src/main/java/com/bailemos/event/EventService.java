package com.bailemos.event;

import com.bailemos.dto.ActivityResponse;
import com.bailemos.dto.EventRequest;
import com.bailemos.dto.EventResponse;
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
  private final WebClient.Builder webClientBuilder;
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
    //get activity id's for the event
    List<ActivityResponse> eventActivities = Arrays.stream(webClientBuilder.build().get()
        .uri("http://activity-microservice/api/activity?eventId=" + eventId)
        .retrieve()
        .bodyToMono(ActivityResponse[].class)
        .block()).toList();

    List<String> activityIds = eventActivities.stream().map(a -> a.getId().toString()).toList();

    return Arrays.stream(webClientBuilder.build().get()
        .uri("http://attendance-microservice/api/attendance/users",
            uriBuilder -> uriBuilder.queryParam("activityIds", activityIds).build())
        .retrieve()
        .bodyToMono(Long[].class)
        .block()).toList();
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
