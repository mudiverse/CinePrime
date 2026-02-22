package com.cineprime.api.theatre.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cineprime.api.dto.ScreenRequest;
import com.cineprime.api.theatre.entity.Screen;
import com.cineprime.api.theatre.entity.Theatre;
import com.cineprime.api.theatre.repository.ScreenRepo;
import com.cineprime.api.theatre.repository.TheatreRepo;

import jakarta.annotation.Nullable;

@Service
public class ScreenService {

    private final ScreenRepo screenRepo;

    ScreenService(ScreenRepo screenRepo) {
        this.screenRepo = screenRepo;
    }

    @Autowired
    private TheatreRepo theatreRepo;

    public @Nullable Object createScreen(ScreenRequest screen){

        //save the screen in db
        //search the theatre by id so that we can set that id to the response and request
        Theatre theatre = theatreRepo.findById(screen.getTheatreId()).orElseThrow(()->new RuntimeException("Theatre not found"));

        Screen screen1 = new Screen();

        screen1.setName(screen.getName());
        screen1.setTheatre(theatre);
        screen1.setTotalSeats(screen.getTotalSeats());

        return screenRepo.save(screen1);

    };
}
