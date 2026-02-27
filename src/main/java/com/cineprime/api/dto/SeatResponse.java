package com.cineprime.api.dto;

import com.cineprime.api.common.constants.BookingStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
@ToString
public class SeatResponse {
    public String seatNumber;
    public BookingStatus bookingStatus;
}
