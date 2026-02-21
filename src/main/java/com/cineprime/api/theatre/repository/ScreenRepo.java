package com.cineprime.api.theatre.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cineprime.api.theatre.entity.Screen;

@Repository
public interface ScreenRepo extends JpaRepository<Screen,Long>{   
}
