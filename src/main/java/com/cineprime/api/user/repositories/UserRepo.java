package com.cineprime.api.user.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cineprime.api.user.entity.User;
import java.util.Optional;

@Repository
public interface UserRepo  extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

}
