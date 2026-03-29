package com.cineprime.api.reccomendation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor @NoArgsConstructor
@Setter @Getter
public class MovieResponse {
    private Long movieId;
    private String title;
    private String genre;
}
