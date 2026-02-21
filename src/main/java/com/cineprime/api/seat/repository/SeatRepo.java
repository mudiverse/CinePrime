package com.cineprime.api.seat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cineprime.api.seat.entity.Seat;
import com.cineprime.api.show.entity.Show;
import java.util.List;


@Repository
public interface SeatRepo extends JpaRepository<Seat,Long> {

    //custom finder method hai

    List<Seat> findByShow(Show show);

}
