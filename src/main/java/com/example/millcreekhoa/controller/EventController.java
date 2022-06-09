package com.example.millcreekhoa.controller;

import com.example.millcreekhoa.data.EventDto;
import com.example.millcreekhoa.entity.EventEntity;
import com.example.millcreekhoa.service.EventService;
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
