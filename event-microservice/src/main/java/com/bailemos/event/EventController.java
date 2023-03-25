package com.bailemos.event;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/event")
@RequiredArgsConstructor
public class EventController {

  private final EventService eventService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void createEvent(@RequestBody EventRequest requestEvent) {
    eventService.createEvent(requestEvent);
  }

  @GetMapping("/{eventId}")
  @ResponseStatus(HttpStatus.OK)
  public EventResponse getEvent(@PathVariable Long eventId) {
    return eventService.getEvent(eventId);
  }

  @GetMapping("/all")
  @ResponseStatus(HttpStatus.OK)
  public List<EventResponse> getEvents() {//TODO add pagination
    return eventService.getAllEvents();
  }

  @GetMapping("/usersInAttendance")
  @ResponseStatus(HttpStatus.OK)
  public List<Long> getUsersInAttendance(@RequestParam Long eventId) {
    return eventService.getUsersInAttendance(eventId);
  }

  //TODO get all event types ?
}
