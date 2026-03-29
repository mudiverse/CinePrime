package com.cineprime.api.reccomendation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cineprime.api.reccomendation.dto.MovieResponse;
import com.cineprime.api.reccomendation.service.ReccomendationService;

@RestController
@RequestMapping("/api/reccomendations")
public class ReccomendationController {

    @Autowired
    private  ReccomendationService reccomendationService;

    @GetMapping("/{userId}")
    public List<MovieResponse> getReccomendations(@PathVariable Long userId) {
        // Logic to fetch and return movie recommendations
        return reccomendationService.getRecommendation(userId);
    }

}
