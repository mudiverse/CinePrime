package com.cineprime.api.show.service;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import com.cineprime.api.dto.ShowRequest;
import com.cineprime.api.dto.ShowResponse;
import com.cineprime.api.movie.entity.Movie;
import com.cineprime.api.movie.repositories.MovieRepo;
import com.cineprime.api.seat.service.SeatService;
import com.cineprime.api.show.entity.Show;
import com.cineprime.api.show.repository.ShowRepo;
import com.cineprime.api.theatre.entity.Screen;
import com.cineprime.api.theatre.repository.ScreenRepo;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    private MovieRepo movieRepo;
    @Autowired
    private ScreenRepo screenRepo;
    @Autowired
    private ShowRepo showRepo;

    @Autowired
    private SeatService seatService;

    public @Nullable Object createShow(ShowRequest show) {
        // fetch movie and Screen by id's

        Movie movie = movieRepo.findById(show.getMovieId()).orElseThrow(() -> new RuntimeException("Movie not found"));
        Screen screen = screenRepo.findById(show.getScreenId())
                .orElseThrow(() -> new RuntimeException("Screen not found"));

        // save the show object and creates seat
        Show show1 = new Show();
        show1.setBasePrice(show.getBasePrice());
        show1.setMovie(movie);
        show1.setScreen(screen);
        show1.setStartTime(show.getStartTime());

        LocalDateTime endTime = show1.getStartTime().plusMinutes(movie.getDuration() + 15);

        // save in the
        show1.setEndTime(endTime);
        showRepo.save(show1);
        // now create and save seats per show
        seatService.generateSeats(show1);
        return "Show CreatedSuccessFully with id: " + show1.getShowid();
    };

    public List<ShowResponse> getShowsByMovie(Long movieId) {
        //validation
         if (!movieRepo.existsById(movieId)) {
        throw new RuntimeException("Movie not found");
    }
        List<Show>shows = showRepo.findByMovieId(movieId);
        
        return shows.stream()
        .map(show-> new ShowResponse(
            show.getShowid(),
            show.getStartTime(),
            show.getEndTime(),
            show.getBasePrice(),
            show.getScreen().getName()
        ))
        .toList();
    }
}
