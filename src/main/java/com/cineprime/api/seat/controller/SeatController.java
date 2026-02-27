package com.cineprime.api.seat.controller;
import com.cineprime.api.dto.SeatResponse;
import com.cineprime.api.seat.service.SeatService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SeatController {
    //constructor injection
    private final SeatService seatService;
    SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    //endpoint to serve the seat status per show
    @GetMapping("/api/shows/{showId}/seats")
    public List<SeatResponse> getSeatsHandler(@PathVariable Long showId){

        return seatService.getSeatsByShow(showId);
    }

}
