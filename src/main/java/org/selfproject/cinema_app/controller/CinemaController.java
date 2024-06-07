package org.selfproject.cinema_app.controller;

import org.selfproject.cinema_app.model.CinemaEntity;
import org.selfproject.cinema_app.model.MovieEntity;
import org.selfproject.cinema_app.repository.CinemaRepository;
import org.selfproject.cinema_app.repository.MovieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins="http://localhost:3000")
@RestController
public class CinemaController {

    private final CinemaRepository cinemaRepository;
    private final MovieRepository movieRepository;

    CinemaController(CinemaRepository cinemaRepository, MovieRepository movieRepository){
        this.movieRepository = movieRepository;
        this.cinemaRepository = cinemaRepository;

    }

    @GetMapping("/api/cinemas")
    public ResponseEntity<List<CinemaEntity>>getAllCinemas(){
        return new ResponseEntity<>(cinemaRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/api/cinemas")
    public ResponseEntity<CinemaEntity> postCinema(@RequestBody CinemaEntity cinemaEntity){
        return new ResponseEntity<>(cinemaRepository.save(cinemaEntity),HttpStatus.CREATED);
    }

    @PutMapping("/api/cinemas/{cinemaId}")
    public ResponseEntity<CinemaEntity> updateCinema(@PathVariable Long cinemaId, @RequestBody CinemaEntity cinemaEntity){
        CinemaEntity optionalCinemaEntity = cinemaRepository.findById(cinemaId).orElse(null);
        if(optionalCinemaEntity != null){
            CinemaEntity existingCinemaEntity = optionalCinemaEntity;
            existingCinemaEntity.setName(cinemaEntity.getName());
            existingCinemaEntity.setCapacity(cinemaEntity.getCapacity());
            existingCinemaEntity.setPrice(cinemaEntity.getPrice());
            existingCinemaEntity.setPlayingMovies(cinemaEntity.getPlayingMovies());
            CinemaEntity updatedCinemaEntity = cinemaRepository.save(existingCinemaEntity);
            return new ResponseEntity<>(updatedCinemaEntity,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @DeleteMapping("/api/cinemas/{cinemaId}")
    public ResponseEntity<Void> deleteCinema(@PathVariable Long cinemaId){
        cinemaRepository.deleteById(cinemaId);
        return new ResponseEntity<>(HttpStatus.OK);
    }



   @PostMapping("/api/cinemas/{cinemaId}/movies/{movieName}")
    public ResponseEntity<CinemaEntity> addMovieToCinema(@PathVariable Long cinemaId, @PathVariable String movieName) {
        CinemaEntity cinemaEntity = cinemaRepository.findById(cinemaId).orElseThrow(() -> new RuntimeException("Cinema not found with id: " + cinemaId));
        MovieEntity movieEntity = movieRepository.findByName(movieName).orElseThrow(() -> new RuntimeException("Movie not found with name: " + movieName));
        cinemaEntity.getPlayingMovies().add(movieEntity);
        return new ResponseEntity<>(cinemaRepository.save(cinemaEntity), HttpStatus.OK);
    }

//
//    @DeleteMapping("/api/cinemas/{cinemaId}/movies/{movieId}")
//    public ResponseEntity<CinemaDTO> removeMovieFromCinema(@PathVariable Long cinemaId, @PathVariable Long movieId) {
//        return new ResponseEntity<>(cinemaService.removeMovieFromCinema(cinemaId, movieId), HttpStatus.OK);
//    }
}
