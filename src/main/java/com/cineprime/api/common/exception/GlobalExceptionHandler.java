package com.cineprime.api.common.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //seat already booked exception ka handler method hai

    @ExceptionHandler(SeatAlreadyBookedException.class)
    public ResponseEntity<?> handleSeatAlreadyBookedException(SeatAlreadyBookedException ex) {
        // Return a response with appropriate status code and message
        return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body(new ErrorResponseDTO(ex.getMessage(), 
            HttpStatus.INTERNAL_SERVER_ERROR.value(), System.currentTimeMillis()));
    }

    //handle a generic exception to catch any unhandled exceptions

    public ResponseEntity<?> handleGenericException(Exception ex) {
        return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body(new ErrorResponseDTO(ex.getMessage(), 
            HttpStatus.INTERNAL_SERVER_ERROR.value(), System.currentTimeMillis()));
        
    }
}
