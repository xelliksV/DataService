package com.apihack.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsentResponse {
    private String request_id;
    private String consent_id;
    private String status;
    private String message;
    private LocalDateTime created_at;
    private boolean auto_approved;
}
