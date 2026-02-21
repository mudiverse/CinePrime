package com.cineprime.api.show.entity;
import java.sql.Time;
import java.util.List;

import com.cineprime.api.movie.entity.Movie;
import com.cineprime.api.seat.entity.Seat;
import com.cineprime.api.theatre.entity.Screen;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "shows")
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long showid;
    private Time startTime;
    private Time endTime;
    private Integer basePrice;

    //imp relation with show 1 show has movie , 1 show 1 screen bue many show ek theatre, many show of 1movie

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name="screen_id")
    private Screen screen;

    //each show has list of seats
    @OneToMany(mappedBy = "show")
    private List<Seat> seats;
}
