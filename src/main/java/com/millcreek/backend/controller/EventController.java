package com.millcreek.backend.controller;

import com.millcreek.backend.entity.EventEntity;
import com.millcreek.backend.service.EventService;
import com.millcreek.backend.data.EventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class EventController {

    @Autowired
    EventService eventService;

   @PostMapping(value = "/events/new")
    public EventEntity addNewEvent(@RequestBody EventDto eventDto) {
      return eventService.addNewEvent(eventDto);
   }

    @PostMapping(value = "/events/delete")
    public boolean deleteEvent(@RequestBody EventDto eventDto) {
        return eventService.deleteEvent(eventDto);
    }


   @GetMapping(value = "/events")
    public List<EventEntity> getAllFutureEvents() {
       return eventService.getAllFutureEvents();
   }
}
