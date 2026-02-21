package com.cineprime.api.seat.entity;

import com.cineprime.api.show.entity.Show;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "seats",
    uniqueConstraints = @UniqueConstraint(columnNames = {"show_id","seatNumber"})
)
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    
    private Integer seatNumber;
    private Enum statusEnum;

    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;

    @Version
    private Integer version;
}
