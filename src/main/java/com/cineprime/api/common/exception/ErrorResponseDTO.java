package com.cineprime.api.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ErrorResponseDTO {
    private String message;
    private int statusCode;
    private long timestamp;

    
}
