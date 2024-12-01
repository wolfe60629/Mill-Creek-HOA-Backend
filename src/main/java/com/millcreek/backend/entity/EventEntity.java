package com.millcreek.backend.entity;

import com.millcreek.backend.data.EventDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "event")
public class EventEntity {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name="event_name", nullable = false)
    String eventName;

    @Column(name = "description", nullable = true)
    String description;

    @Column(name = "location", nullable = true)
    String location;

    @Column(name = "start_date", columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date", columnDefinition = "TIMESTAMP", nullable = true)
    private LocalDateTime endDate;

    public EventEntity(EventDto eventDto) {
        this.id = eventDto.getId();
        this.eventName = eventDto.getEventName();
        this.description = eventDto.getDescription();
        this.startDate = eventDto.getStartDate();
        this.endDate = eventDto.getEndDate();
        this.location = eventDto.getLocation();

    }
}

