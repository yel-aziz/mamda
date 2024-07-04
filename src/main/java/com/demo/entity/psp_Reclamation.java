package com.demo.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "psp_Reclamation")
public class psp_Reclamation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReclamation;

    private int idUser;

    private int idProspect;

    @Column(length = 500)
    private String reclamation;

    @Temporal(TemporalType.DATE)
    private Date dateReclamation;

    private int idType;

    private int idMotif;

    private int idSite;

    private int idStatut;

    @Column(length = 1)
    private char priorite;


    public int getIdReclamation() {
        return idReclamation;
    }

    public void setIdReclamation(int idReclamation) {
        this.idReclamation = idReclamation;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdProspect() {
        return idProspect;
    }

    public void setIdProspect(int idProspect) {
        this.idProspect = idProspect;
    }

    public String getReclamation() {
        return reclamation;
    }

    public void setReclamation(String reclamation) {
        this.reclamation = reclamation;
    }

    public Date getDateReclamation() {
        return dateReclamation;
    }

    public void setDateReclamation(Date dateReclamation) {
        this.dateReclamation = dateReclamation;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public int getIdMotif() {
        return idMotif;
    }

    public void setIdMotif(int idMotif) {
        this.idMotif = idMotif;
    }

    public int getIdSite() {
        return idSite;
    }

    public void setIdSite(int idSite) {
        this.idSite = idSite;
    }

    public int getIdStatut() {
        return idStatut;
    }

    public void setIdStatut(int idStatut) {
        this.idStatut = idStatut;
    }

    public char getPriorite() {
        return priorite;
    }

    public void setPriorite(char priorite) {
        this.priorite = priorite;
    }
}
