package com.millcreek.backend.data;

import lombok.Data;

@Data
public class RequestDocumentDto {
    String name;
    String friendlyName;
    String item;
    String category;
    String description;
    String editableColumns;
}
