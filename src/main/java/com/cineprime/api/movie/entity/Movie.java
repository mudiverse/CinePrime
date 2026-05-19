package com.cineprime.api.movie.entity;

import com.cineprime.api.show.entity.Show;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="movies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TMDB original id
    @Column(unique = true)
    private Long tmdbId;

    private String title;
    private Integer duration; //in minutes
    private String genre;
    private String language; //which language

    @Column(columnDefinition = "TEXT")
    private String overview;

    private Double rating;


}
