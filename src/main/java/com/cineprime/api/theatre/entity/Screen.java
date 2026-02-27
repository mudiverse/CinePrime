package com.cineprime.api.theatre.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity@Table(name = "screens")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer totalSeats;

    //yaha pe screen is m : 1 mapping in DB
    @ManyToOne
    @JoinColumn(name="theatre_id")
    private Theatre theatre;

}
