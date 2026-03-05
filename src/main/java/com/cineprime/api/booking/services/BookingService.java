package com.cineprime.api.booking.services;
import java.util.List;
import java.util.Optional;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cineprime.api.booking.entity.Booking;
import com.cineprime.api.booking.entity.BookingSeat;
import com.cineprime.api.booking.entity.IdempotencyRecord;
import com.cineprime.api.booking.repositories.BookingRepo;
import com.cineprime.api.booking.repositories.BookingSeatRepo;
import com.cineprime.api.booking.repositories.IdempotencyRepo;
import com.cineprime.api.common.constants.BookingStatus;
import com.cineprime.api.common.constants.SeatBookingStatus;
import com.cineprime.api.dto.BookingRequest;
import com.cineprime.api.seat.entity.Seat;
import com.cineprime.api.seat.repository.SeatRepo;
import com.cineprime.api.show.repository.ShowRepo;
import com.cineprime.api.user.repositories.UserRepo;
import jakarta.transaction.Transactional;

@Service
public class BookingService {

    private final BookingSeatRepo bookingSeatRepo;

    private final BookingRepo bookingRepo;

    private final ShowRepo showRepo;

    private final UserRepo userRepo;

    @Autowired
    private  IdempotencyRepo idempotencyRepo;

    @Autowired
    private SeatRepo seatRepo;

    BookingService(UserRepo userRepo, ShowRepo showRepo, BookingRepo bookingRepo, BookingSeatRepo bookingSeatRepo) {
        this.userRepo = userRepo;
        this.showRepo = showRepo;
        this.bookingRepo = bookingRepo;
        this.bookingSeatRepo = bookingSeatRepo;
    }

    @Transactional
    public @Nullable Object bookSeats(Long userId, BookingRequest request, String idempodencyKey) {
       
       //check idempotency key to avoid duplicattions
       Optional<IdempotencyRecord> existing = Optional.ofNullable(idempotencyRepo.findByIdempotencyKey(idempodencyKey));
    
       //agar exist krta hai to purana return hoga 
       if(existing.isPresent()){
        //TODO the logic
            return "True";
       }

       //create a processing record if not exists already
       IdempotencyRecord record = new IdempotencyRecord();
       record.setIdempotencyKey(idempodencyKey);
       record.setStatus("PROCESSING");
       idempotencyRepo.save(record);
       
       
        //fetch the seats from the request
       List<Seat> seats = seatRepo.findAllById(request.getSeatIds());
       
       //need to validate if the seats 
       validateShow(seats, request.getShowId());
       //now chek if the seats requested are available

       for(Seat seat:seats){
         if(seat.getStatusEnum() != BookingStatus.AVAILABLE){
            throw new RuntimeException("Seat Not Available") ; //implement a SeatNotFoundException
         }
       }

       //else mark the seats as Booked
       for(Seat seat:seats){
        seat.setStatusEnum(BookingStatus.BOOKED);
       }

       //save all the seats
       seatRepo.saveAll(seats);
       
       ///IMP Create BOOKing and save it
       
       Booking booking = new Booking();
       
       booking.setUser(userRepo.findById(userId).orElseThrow());
       booking.setShow(showRepo.findById(request.getShowId()).orElseThrow());
       booking.setStatus(SeatBookingStatus.CONFIRMED);
       booking.setTotalAmount(1000.100);//dummy value //TODO CHange the calc by using a function

       bookingRepo.save(booking);


       //now create the BOOKing Seat
       for(Seat seat:seats){
        BookingSeat bs = new BookingSeat();
        bs.setBooking(booking);  // saatr bookedSeat ko BOOKIng se map karenge
        bs.setSeat(seat);
        //save each of the bs
        bookingSeatRepo.save(bs);
       }

       //simulate payments here
       /* Here  paymentService.processPayment() */
       //

       //save the idempodency res
       record.setStatus("COMPLETED");
       record.setResponseBody("Booking A, TIne etc");

       idempotencyRepo.save(record);

        return "Booking Response here";
    }


    public boolean validateShow(List<Seat>seats, Long Id){
        //check if all seats have same Id/show if
        for(Seat seat :seats){
            if(seat.getShow().getShowid() !=Id){
                return false;//if any seat belong to diff show id then false
            }
        }
        return true;
    }

}
