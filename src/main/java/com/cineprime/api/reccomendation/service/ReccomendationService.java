package com.cineprime.api.reccomendation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cineprime.api.movie.entity.Movie;
import com.cineprime.api.movie.repositories.MovieRepo;
import com.cineprime.api.reccomendation.dto.MovieResponse;

@Service
public class ReccomendationService {

    @Autowired
    private MovieRepo movieRepository;

    public List<MovieResponse> getRecommendation(Long userId) {
        //ye method user ke liye movie recommendations return karega
        //will bring all movies for userId and return list of MovieResponse
        //right now we will show dummy movies now for all, later ML
        
        //get list of movies 1: Call ML (Dummy)
        List<Long> recommendedMovie = getDummy(userId);

        //fetch from DB 
        List<Movie> movies = movieRepository.findAllById(recommendedMovie);
        
        //convert to MovieResponse

        return  movies.stream().map(movie -> {
            MovieResponse response = new MovieResponse();
            response.setGenre(movie.getGenre());
            response.setTitle(movie.getTitle());
            return response;
        }).toList();
    }

    private List<Long> getDummy(Long userId) {
        //ye method dummy movie ids return karega
        return List.of(1L, 2L, 3L);
    }



}
