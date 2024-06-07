package org.selfproject.cinema_app.model;

import jakarta.persistence.*;


@Entity
@Table(name = "BiletAl")
public class BiletAlEntity {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long secilenFilm;
    private String secilenSinema;
    private String secilenTarih;
    private String secilenSeans;
    private Integer ogrenciBiletSayisi;
    private Integer tamBiletSayisi;
    private String secilenKoltuklar;
    private Double price;



    public BiletAlEntity(Long id, Double price,Long secilenFilm, String secilenSinema, String secilenTarih, String secilenSeans, Integer ogrenciBiletSayisi, Integer tamBiletSayisi, String secilenKoltuklar) {
        this.id = id;
        this.price = price;
        this.secilenFilm = secilenFilm;
        this.secilenSinema = secilenSinema;
        this.secilenTarih = secilenTarih;
        this.secilenSeans = secilenSeans;
        this.ogrenciBiletSayisi = ogrenciBiletSayisi;
        this.tamBiletSayisi = tamBiletSayisi;
        this.secilenKoltuklar = secilenKoltuklar;
    }

    public BiletAlEntity() {

    }

    @Override
    public String toString() {
        return "BiletAlEntity{" +
                "id=" + id +
                ", price=" + price +
                ", secilenFilm='" + secilenFilm + '\'' +
                ", secilenSinema='" + secilenSinema + '\'' +
                ", secilenTarih='" + secilenTarih + '\'' +
                ", secilenSeans='" + secilenSeans + '\'' +
                ", ogrenciBiletSayisi=" + ogrenciBiletSayisi +
                ", tamBiletSayisi=" + tamBiletSayisi +
                ", secilenKoltuklar='" + secilenKoltuklar + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSecilenSinema() {
        return secilenSinema;
    }

    public void setSecilenSinema(String secilenSinema) {
        this.secilenSinema = secilenSinema;
    }

    public String getSecilenTarih() {
        return secilenTarih;
    }

    public void setSecilenTarih(String secilenTarih) {
        this.secilenTarih = secilenTarih;
    }

    public String getSecilenSeans() {
        return secilenSeans;
    }

    public void setSecilenSeans(String secilenSeans) {
        this.secilenSeans = secilenSeans;
    }

    public Integer getOgrenciBiletSayisi() {
        return ogrenciBiletSayisi;
    }

    public void setOgrenciBiletSayisi(Integer ogrenciBiletSayisi) {
        this.ogrenciBiletSayisi = ogrenciBiletSayisi;
    }

    public Integer getTamBiletSayisi() {
        return tamBiletSayisi;
    }

    public void setTamBiletSayisi(Integer tamBiletSayisi) {
        this.tamBiletSayisi = tamBiletSayisi;
    }

    public String getSecilenKoltuklar() {
        return secilenKoltuklar;
    }

    public void setSecilenKoltuklar(String secilenKoltuklar) {
        this.secilenKoltuklar = secilenKoltuklar;
    }

    public Long getSecilenFilm() {
        return secilenFilm;
    }
    public void setSecilenFilm(Long secilenFilm) {
        this.secilenFilm = secilenFilm;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


}