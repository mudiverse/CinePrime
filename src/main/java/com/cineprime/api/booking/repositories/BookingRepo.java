package com.cineprime.api.booking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cineprime.api.booking.entity.Booking;

@Repository
public interface BookingRepo  extends JpaRepository<Booking,Long>{

}
