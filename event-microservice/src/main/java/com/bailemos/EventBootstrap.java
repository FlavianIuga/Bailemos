package com.bailemos;

import com.bailemos.event.Event;
import com.bailemos.event.EventRepository;
import com.bailemos.event.EventType;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventBootstrap implements CommandLineRunner {

  private final EventRepository eventRepository;

  @Override
  public void run(String... args) {
    Event e1 = new Event(1L, "Event 1", "Event Description 1", 1L, EventType.FESTIVAL, new Date(),
        new Date());
    Event e2 = new Event(2L, "Event 2", "Event Description 2", 2L, EventType.FESTIVAL, new Date(),
        new Date());
    Event e3 = new Event(3L, "Event 3", "Event Description 3", 3L, EventType.FESTIVAL, new Date(),
        new Date());
    eventRepository.save(e1);
    eventRepository.save(e2);
    eventRepository.save(e3);
  }

}
