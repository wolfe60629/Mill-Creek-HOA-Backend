package com.millcreek.backend.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class EventDto {
    private int id = 0;
    private String eventName;
    private String description;
    private String location;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
