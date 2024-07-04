package com.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "villes")
public class villes {

    @Id
    private int villeId;

    @Column(length = 200)
    private String libelle;

    @Column(length = 1)
    private String actif;


    public int getVilleId() {
        return villeId;
    }

    public void setVilleId(int villeId) {
        this.villeId = villeId;
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
