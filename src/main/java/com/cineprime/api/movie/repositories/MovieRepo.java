package com.cineprime.api.movie.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cineprime.api.movie.entity.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long>{

}
