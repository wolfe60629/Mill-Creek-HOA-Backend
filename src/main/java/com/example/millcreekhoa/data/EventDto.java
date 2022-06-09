package com.example.millcreekhoa.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class EventDto {
    private int id = 0;
    private String eventName;
    private String description;
    private String location;
    private LocalDateTime date;
}
