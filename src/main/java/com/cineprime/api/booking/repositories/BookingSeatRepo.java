package com.cineprime.api.booking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cineprime.api.booking.entity.BookingSeat;

@Repository
public interface BookingSeatRepo extends JpaRepository<BookingSeat,Long> {
    
}
