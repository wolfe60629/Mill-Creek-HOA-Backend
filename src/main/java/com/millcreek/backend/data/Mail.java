package com.millcreek.backend.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Mail {
    String email;
    String subject;
    String message;
    String base64;
}
