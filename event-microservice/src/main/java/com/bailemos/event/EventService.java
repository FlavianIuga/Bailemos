package com.bailemos.event;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class EventService {

  private final EventRepository eventRepository;

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
