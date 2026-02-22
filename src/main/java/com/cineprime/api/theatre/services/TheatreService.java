package com.cineprime.api.theatre.services;
import org.springframework.stereotype.Service;

import com.cineprime.api.theatre.entity.Theatre;
import com.cineprime.api.theatre.repository.TheatreRepo;
import org.jspecify.annotations.Nullable;

@Service
public class TheatreService {

    private final TheatreRepo theatreRepo;

    TheatreService(TheatreRepo theatreRepo) {
        this.theatreRepo = theatreRepo;
    }

    public @Nullable Object  createTheatre(Theatre theatre){
        Theatre theatre1 = new Theatre();
        theatre1.setAddress(theatre.getAddress());
        theatre1.setName(theatre.getName());
        return theatreRepo.save(theatre1);

    };

}
