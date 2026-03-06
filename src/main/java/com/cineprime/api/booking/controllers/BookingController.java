package com.cineprime.api.booking.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cineprime.api.booking.services.BookingService;
import com.cineprime.api.dto.BookingRequest;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {    

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<?> bookSeatsHandler(@RequestHeader("Idempotency_Key") String idempodencyKey,
       @RequestBody BookingRequest request)
    {
        //as we get  user id from the booking request // or we get jwq in header so we can get user
        
        Long userId = request.getUserId();
        return ResponseEntity.ok(bookingService.bookSeats(userId,request,idempodencyKey));
    }

}
