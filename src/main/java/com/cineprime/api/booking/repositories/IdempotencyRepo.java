package com.cineprime.api.booking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cineprime.api.booking.entity.IdempotencyRecord;
import java.util.List;


@Repository
public interface IdempotencyRepo  extends JpaRepository<IdempotencyRecord,Long>{

    //method to find the record by the key
    IdempotencyRecord findByIdempotencyKey(String idempotencyKey);
    
}
