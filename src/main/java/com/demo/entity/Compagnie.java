package com.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "compagnie")
public class Compagnie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "compagnie_id")
    private int companieId;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "actif")
    private String actif;

    public int getCompanieId() {
        return companieId;
    }

    public void setLibelle(String set_libelle) {
        this.libelle = set_libelle;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setActif(String set_actif) {
        this.actif = set_actif;
    }

    public String getActif() {
        return this.actif;
    }

}
