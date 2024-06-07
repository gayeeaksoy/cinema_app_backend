package org.selfproject.cinema_app.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Cinemas")
public class CinemaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer capacity;
    private Double price;
    @ManyToMany
    @JoinTable(
        name="cinema_movie",
        joinColumns = @JoinColumn(name="c_id"),
        inverseJoinColumns = @JoinColumn(name = "m_id"))
    private List<MovieEntity> playingMovies;



    public CinemaEntity(String name, Integer capacity, Double price, List<MovieEntity> playingMovies) {
        this.name = name;
        this.capacity = capacity;

        this.price = price;
        this.playingMovies = playingMovies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<MovieEntity> getPlayingMovies() {
        return playingMovies;
    }

    public void setPlayingMovies(List<MovieEntity> playingMovies) {
        this.playingMovies = playingMovies;
    }

    public CinemaEntity() {
    }

    @Override
    public String toString() {
        return "CinemaEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                ", playingMovies=" + playingMovies +
                '}';
    }
}
