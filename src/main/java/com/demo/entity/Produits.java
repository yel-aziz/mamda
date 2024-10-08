package com.demo.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Produits")

public class Produits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produit_id")
    private int produitId;

    @Column(name = "societe_id")
    private int sociteId;

    @Column(name = "code")
    private char code;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "actif")
    private char actif;

    public void setSocieteId(int societeid) {
        this.sociteId = societeid;
    }

    public int getSociteId() {
        return this.sociteId;
    }

    public void setCode(char code) {
        this.code = code;
    }

    public int getProduitsId() {
        return this.produitId;
    }

    public char getCode() {
        return this.code;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setActif(char actif) {
        this.actif = actif;
    }

    public char getActif() {

        return this.actif;
    }

}
