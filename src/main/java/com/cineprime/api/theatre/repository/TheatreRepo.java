package com.cineprime.api.theatre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cineprime.api.theatre.entity.Theatre;

@Repository
public interface TheatreRepo extends JpaRepository<Theatre,Long> {

}
