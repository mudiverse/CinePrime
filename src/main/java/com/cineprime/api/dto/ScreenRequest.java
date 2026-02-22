package com.cineprime.api.dto;

import com.cineprime.api.theatre.entity.Theatre;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ScreenRequest {
    private String name;
    private Integer totalSeats;
    private Long theatreId;
}
