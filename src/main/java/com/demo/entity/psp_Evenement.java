package com.demo.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "psp_Evenement")
public class psp_Evenement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEve;

    private int idPsp;

    @Column(length = 500)
    private String nomPsp;

    private int idEvtype;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

    private int idUsers;

    // Getters and Setters

    public int getIdEve() {
        return idEve;
    }

    public void setIdEve(int idEve) {
        this.idEve = idEve;
    }

    public int getIdPsp() {
        return idPsp;
    }

    public void setIdPsp(int idPsp) {
        this.idPsp = idPsp;
    }

    public String getNomPsp() {
        return nomPsp;
    }

    public void setNomPsp(String nomPsp) {
        this.nomPsp = nomPsp;
    }

    public int getIdEvtype() {
        return idEvtype;
    }

    public void setIdEvtype(int idEvtype) {
        this.idEvtype = idEvtype;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public int getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }
}
