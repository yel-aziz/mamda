package com.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "psp_Ticket")
public class psp_Ticket {

    @Id
    private int idType;

    @Column(length = 100)
    private String libelleT;

    @Column(length = 1)
    private char active;


    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getLibelleT() {
        return libelleT;
    }

    public void setLibelleT(String libelleT) {
        this.libelleT = libelleT;
    }

    public char getActive() {
        return active;
    }

    public void setActive(char active) {
        this.active = active;
    }
}
