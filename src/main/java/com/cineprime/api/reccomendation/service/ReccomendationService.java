package com.cineprime.api.reccomendation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.cineprime.api.movie.entity.Movie;
import com.cineprime.api.movie.repositories.MovieRepo;
import com.cineprime.api.reccomendation.dto.MovieResponse;

@Service
public class ReccomendationService {

    @Autowired
    private MovieRepo movieRepository;

    private final WebClient webClient = WebClient.create("http://localhost:3000"); // Assuming ML service is running on this URL

    public List<MovieResponse> getRecommendation(Long userId) {
        //ye method user ke liye movie recommendations return karega
        //will bring all movies for userId and return list of MovieResponse
        //right now we will show dummy movies now for all, later ML
        
        //TODO: get list of movies 1: Call ML (Dummy)
        List<Long> recommendedMovie = callMlService(userId);

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

    private List<Long> callMlService(Long userId) {
        //call the ml api using webCLient
        
        return webClient.get()
            .uri("/recommend?userId="+userId) //imp to keep the name same as in ML service
            .retrieve()
            .bodyToFlux(Long.class)
            .collectList()
            .block();

        //right now dummy return karega
        // return List.of(1L, 2L, 3L);
    }



}
