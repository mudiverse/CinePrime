package com.cineprime.api.show.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cineprime.api.show.entity.Show;

@Repository
public interface ShowRepo extends JpaRepository<Show,Long> {
}
