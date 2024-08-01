package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "psp_Ticket")
public class psp_Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idticket")
    private int idticket;

    @ManyToOne
    @JoinColumn(name = "userticket", nullable = false)
    @JsonBackReference
    private Users user;

    @Column(name = "idType")
    private int idType;

    @Column(length = 100)
    private String libelleT;

    @Column(length = 1)
    private char active;

    // Getters and setters

    public int getIdticket() {
        return idticket;
    }

    public void setIdticket(int idticket) {
        this.idticket = idticket;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

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
