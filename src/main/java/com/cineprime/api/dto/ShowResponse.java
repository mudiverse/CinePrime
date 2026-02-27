package com.cineprime.api.dto;

import java.sql.Time;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShowResponse {
    private Long showId;
     private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer basePrice;
    private String screenName;
}
