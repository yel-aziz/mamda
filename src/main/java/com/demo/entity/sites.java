package com.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sites")
public class sites {

    @Id
    private int siteId;

    @Column(length = 50, nullable = false)
    private String libelle;

    @Column(length = 1, nullable = false)
    private String actif;


    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getActif() {
        return actif;
    }

    public void setActif(String actif) {
        this.actif = actif;
    }
}
