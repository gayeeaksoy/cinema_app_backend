package org.selfproject.cinema_app.repository;

import org.selfproject.cinema_app.model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
    Optional<MovieEntity> findByName(String name);

}