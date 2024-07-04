package com.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "psp_motif")
public class psp_motif {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMotif;

    @Column(length = 100)
    private String libelleM;

    private int idType;

    @Column(length = 1)
    private char active;

    // Getters and Setters

    public int getIdMotif() {
        return idMotif;
    }

    public void setIdMotif(int idMotif) {
        this.idMotif = idMotif;
    }

    public String getLibelleM() {
        return libelleM;
    }

    public void setLibelleM(String libelleM) {
        this.libelleM = libelleM;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public char getActive() {
        return active;
    }

    public void setActive(char active) {
        this.active = active;
    }
}
