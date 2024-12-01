package com.millcreek.backend.data;

import lombok.Data;

@Data
public class DocumentDto {
    String name;
    String friendlyName;
    String item;
    String category;
    String description;
}
