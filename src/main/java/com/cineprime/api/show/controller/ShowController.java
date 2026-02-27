package com.cineprime.api.show.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cineprime.api.dto.ShowRequest;
import com.cineprime.api.dto.ShowResponse;
import com.cineprime.api.show.service.ShowService;

@RestController
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping("/api/shows")
    public ResponseEntity<?> createShowHandler(@RequestBody ShowRequest show) {
        return ResponseEntity.ok(showService.createShow(show));
    }

    // enpoints for users to get shows by movies id

    @GetMapping("/api/movies/{movieId}/shows")
    public List<ShowResponse> getShowsByMovieHandler(@PathVariable Long movieId) {
        
        return showService.getShowsByMovie(movieId);
    }

}
