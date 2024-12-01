package com.millcreek.backend.service;

import com.millcreek.backend.entity.EventEntity;
import com.millcreek.backend.repo.EventRepository;
import com.millcreek.backend.data.EventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    public List<EventEntity> getAllFutureEvents() {
        // Pull all events
        List<EventEntity> allEvents = eventRepository.findAllByOrderByStartDateAsc();

        //only show events in future
        LocalDateTime presentDate = LocalDateTime.now();
        List<EventEntity> futureEvents = allEvents.stream().filter((event) -> {
            if (event.getEndDate() != null) {
                return presentDate.isBefore(event.getEndDate());
            }else if (event.getStartDate() != null) {
                return presentDate.isBefore(event.getStartDate());
            }else {
                return false;
            }
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

