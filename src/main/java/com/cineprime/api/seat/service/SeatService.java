package com.cineprime.api.seat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cineprime.api.common.constants.AppConstants;
import com.cineprime.api.common.constants.BookingStatus;
import com.cineprime.api.dto.SeatResponse;
import com.cineprime.api.seat.entity.Seat;
import com.cineprime.api.seat.repository.SeatRepo;
import com.cineprime.api.show.entity.Show;
import com.cineprime.api.show.repository.ShowRepo;

@Service
public class SeatService {  

    @Autowired
    private ShowRepo showRepo;

    private final SeatRepo seatRepo;

    SeatService(SeatRepo seatRepo) {
        this.seatRepo = seatRepo;
    }

    public void generateSeats(Show show1) {
        //we will generate a list of seats
        int totalSeats = show1.getScreen().getTotalSeats();

        for(int i=1;i<=totalSeats;i++){
            Seat seat = new Seat();
            seat.setShow(show1);
            seat.setSeatNumber("H"+i);
            seat.setStatusEnum(BookingStatus.AVAILABLE);

            seatRepo.save(seat);
        }
    }

    public List<SeatResponse> getSeatsByShow(Long showId) {
        //show nikal lo from the showID
        Show show = showRepo.findById(showId).orElseThrow(()->new RuntimeException("Show id not found"));
        List<Seat> seats = seatRepo.findByShow(show);
        //using stream api to convert to a seatrespone
        return seats.stream()
            .map(seat-> new SeatResponse(
                seat.getSeatNumber(),
                seat.getStatusEnum()
            ))
            .toList();
    }
}
