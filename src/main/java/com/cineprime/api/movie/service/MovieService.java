package com.cineprime.api.movie.service;

import com.cineprime.api.movie.repositories.MovieRepo;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cineprime.api.movie.entity.Movie;

@Service
public class MovieService {

    @Autowired
    private  MovieRepo movieRepo;

    MovieService(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    public @Nullable Object createMovie(Movie movie) {

        //use movie repo and request to store the movie in the DB
        Movie newMovie = new Movie();
        newMovie.setTitle(movie.getTitle());
        newMovie.setDuration(movie.getDuration());
        newMovie.setGenre(movie.getGenre());
        newMovie.setLanguage(movie.getLanguage());

        return movieRepo.save(newMovie);
    }

    public @Nullable Object getAllMovies() {
       //seach the db and fetch the movies 
       
       return movieRepo.findAll();//returns a list of movies
    }

}
