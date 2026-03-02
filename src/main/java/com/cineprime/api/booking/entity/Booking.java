package com.cineprime.api.booking.entity;

import java.sql.Timestamp;

import com.cineprime.api.common.constants.SeatBookingStatus;
import com.cineprime.api.show.entity.Show;
import com.cineprime.api.user.entity.User;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bookings")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    //User can have many bookings
    @ManyToOne
    private User user;

    //One show can have many bookings
    @ManyToOne
    private Show show;

    //fields
    private Double totalAmount;

    @Enumerated(EnumType.STRING)
    private SeatBookingStatus status;

    private String idempotencyKey;

    private Timestamp createdAt;
}
