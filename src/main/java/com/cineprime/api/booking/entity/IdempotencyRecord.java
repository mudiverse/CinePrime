package com.cineprime.api.booking.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "idempotency_records")
@Getter@Setter
@NoArgsConstructor @AllArgsConstructor
public class IdempotencyRecord {

    @Id
    @GeneratedValue
    private Long Id;  //primary keys

    @Column(unique = true)
    String idempotencyKey;

    private Long userId;
    private String status; //[processing/completed]

    private String responseBody;
    private LocalDateTime createdAt;
}
