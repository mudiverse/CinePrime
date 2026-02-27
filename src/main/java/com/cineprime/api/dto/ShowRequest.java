package com.cineprime.api.dto;

import java.sql.Time;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ShowRequest {
    private Long movieId;
    private Long screenId;
    private LocalDateTime startTime;
    private Integer basePrice;
}
