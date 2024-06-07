package org.selfproject.cinema_app;

import org.selfproject.cinema_app.controller.MovieController;
import org.selfproject.cinema_app.model.CinemaEntity;
import org.selfproject.cinema_app.model.MovieEntity;
import org.selfproject.cinema_app.repository.MovieRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CinemaAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaAppApplication.class, args);



    }

}
