package org.selfproject.cinema_app.model;

import jakarta.persistence.*;

@Entity
@Table(name="Users")
public class UserEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String email;
        private String password;
        private String role;
        private String favoriteList;

    public UserEntity() {
        this.role = "USER";
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getFavoriteList() {return favoriteList;}
    public void setFavoriteList(String favoriteList) {this.favoriteList = favoriteList;}

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                "deneme='" + favoriteList + '\'' +
                '}';
    }
}


