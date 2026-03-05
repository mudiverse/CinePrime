package com.cineprime.api.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
@ToString
public class BookingRequest {

    private Long userId;
    private Long showId;
    private List<Long> seatIds;
}
