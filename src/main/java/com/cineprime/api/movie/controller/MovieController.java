package com.cineprime.api.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cineprime.api.movie.entity.Movie;
import com.cineprime.api.movie.service.MovieService;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    //func to create and save the movie in  DB

    @PostMapping
    public ResponseEntity<?>createMovieHandler(@RequestBody Movie movie){
        return ResponseEntity.ok(movieService.createMovie(movie));
    }



    //getter method wich fetches the Movie for the User in Fronntend (Get)
    @GetMapping
    public ResponseEntity<?>getMoviesHandler(){
        return ResponseEntity.ok(movieService.getAllMovies());
    }


}
