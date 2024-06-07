package org.selfproject.cinema_app.controller;

import org.selfproject.cinema_app.model.MovieEntity;
import org.selfproject.cinema_app.repository.MovieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins="http://localhost:3000")
@RestController
public class MovieController {


    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }



    @PostMapping("/api/movies")
    public ResponseEntity<MovieEntity> postMovie(@RequestBody MovieEntity movieEntity){
        return new ResponseEntity<>(movieRepository.save(movieEntity), HttpStatus.CREATED);
    }


    @PutMapping("/api/movies/{name}")
    public ResponseEntity<MovieEntity> updateMovie(@PathVariable String name, @RequestBody MovieEntity movieEntity) {
        Optional<MovieEntity> movieEntityOptional = movieRepository.findByName(name);

        if (movieEntityOptional.isPresent()) {
            MovieEntity existingMovieEntity = movieEntityOptional.get();
            // Check each field and update only if it is not null
            if (movieEntity.getName() != null) {
                existingMovieEntity.setName(movieEntity.getName());
            }
            if (movieEntity.getDuration() != null) {
                existingMovieEntity.setDuration(movieEntity.getDuration());
            }
            if (movieEntity.getGenre() != null) {
                existingMovieEntity.setGenre(movieEntity.getGenre());
            }
            if (movieEntity.getRating() != null) {
                existingMovieEntity.setRating(movieEntity.getRating());
            }
            if (movieEntity.getCast() != null) {
                existingMovieEntity.setCast(movieEntity.getCast());
            }
            if (movieEntity.getDirector() != null) {
                existingMovieEntity.setDirector(movieEntity.getDirector());
            }
            if (movieEntity.getImageLocation() != null) {
                existingMovieEntity.setImageLocation(movieEntity.getImageLocation());
            }
            if (movieEntity.getReleaseDate() != null) {
                existingMovieEntity.setReleaseDate(movieEntity.getReleaseDate());
            }

            MovieEntity updatedMovieEntity = movieRepository.save(existingMovieEntity);
            return new ResponseEntity<>(updatedMovieEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }





    @DeleteMapping("/api/movies/{name}")
    public ResponseEntity<Void> deleteMovie(@PathVariable String name){
        Optional<MovieEntity> movieEntityOptional = movieRepository.findByName(name);
        if (movieEntityOptional.isPresent()) {
            movieRepository.delete(movieEntityOptional.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/movies")
    public ResponseEntity<List<MovieEntity>> getAllMovie(){
        System.out.println("Get all movies");
        return new ResponseEntity<>(movieRepository.findAll(),HttpStatus.OK);

    }

}