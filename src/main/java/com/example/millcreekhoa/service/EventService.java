package com.example.millcreekhoa.service;

import com.example.millcreekhoa.data.BoardMemberDto;
import com.example.millcreekhoa.data.DocumentDto;
import com.example.millcreekhoa.data.EventDto;
import com.example.millcreekhoa.entity.BoardMemberEntity;
import com.example.millcreekhoa.entity.DocumentEntity;
import com.example.millcreekhoa.entity.EventEntity;
import com.example.millcreekhoa.repo.BoardMemberRepository;
import com.example.millcreekhoa.repo.DocumentRepository;
import com.example.millcreekhoa.repo.EventRepository;
import jdk.jfr.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    public List<EventEntity> getAllFutureEvents() {
        // Pull all events
        List<EventEntity> allEvents = eventRepository.findAllByOrderByDateAsc();



        //only show events in future
        LocalDateTime presentDate = LocalDateTime.now();
        List<EventEntity> futureEvents = allEvents.stream().filter((event) -> {
            return presentDate.isBefore(event.getDate());
        }).collect(Collectors.toList());

        return futureEvents;
    }

    public EventEntity getEventById(int id) {
        return eventRepository.findAllById(id);
    }

    public EventEntity addNewEvent(EventDto eventDto) {
        EventEntity entity = new EventEntity(eventDto);
        return eventRepository.save(entity);
    }

    public boolean deleteEvent(EventDto eventDto) {
        // Make sure that ID is filled out
        if (eventDto.getId() == 0) {
            return false;
        }

        // Get entity from id
        EventEntity entity = eventRepository.findAllById(eventDto.getId());

        if (entity == null) {
            return false;
        }

        eventRepository.delete(entity);
        return true;
    }
}

