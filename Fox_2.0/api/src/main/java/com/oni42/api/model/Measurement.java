package com.oni42.api.model;

import jakarta.persistence.*;

@Entity
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double kopfumfang;
    private Double taille;
    private Double bauch;
    private Double schultern;
    private Double beine;
    private Double brust;

    public Measurement() {}

    public Measurement(Double kopfumfang, Double taille, Double bauch, Double schultern, Double beine, Double brust) {
        this.kopfumfang = kopfumfang;
        this.taille = taille;
        this.bauch = bauch;
        this.schultern = schultern;
        this.beine = beine;
        this.brust = brust;
    }

    public Long getId() { return id; }
    public Double getKopfumfang() { return kopfumfang; }
    public void setKopfumfang(Double kopfumfang) { this.kopfumfang = kopfumfang; }
    public Double getTaille() { return taille; }
    public void setTaille(Double taille) { this.taille = taille; }
    public Double getBauch() { return bauch; }
    public void setBauch(Double bauch) { this.bauch = bauch; }
    public Double getSchultern() { return schultern; }
    public void setSchultern(Double schultern) { this.schultern = schultern; }
    public Double getBeine() { return beine; }
    public void setBeine(Double beine) { this.beine = beine; }
    public Double getBrust() { return brust; }
    public void setBrust(Double brust) { this.brust = brust; }

}
