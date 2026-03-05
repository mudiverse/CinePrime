package com.cineprime.api.booking.entity;

import com.cineprime.api.seat.entity.Seat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//class represents the seat(s) booked under a booking
@Entity
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    private Booking booking;
    @ManyToOne
    private Seat seat;
}