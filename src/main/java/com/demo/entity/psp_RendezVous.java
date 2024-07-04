package com.demo.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "psp_RendezVous")
public class psp_RendezVous {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRDV;

    private int idPsp;

    @Column(length = 500)
    private String nomPsp;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRdv;

    @Column(length = 6)
    private String heure;

    @Column(length = 500)
    private String adresse;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

    private int idUsers;

    private int statut;

    private int typeRdv;

    @Column(columnDefinition = "TEXT")
    private String cr;


    public int getIdRDV() {
        return idRDV;
    }

    public void setIdRDV(int idRDV) {
        this.idRDV = idRDV;
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

    public Date getDateRdv() {
        return dateRdv;
    }

    public void setDateRdv(Date dateRdv) {
        this.dateRdv = dateRdv;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
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

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public int getTypeRdv() {
        return typeRdv;
    }

    public void setTypeRdv(int typeRdv) {
        this.typeRdv = typeRdv;
    }

    public String getCr() {
        return cr;
    }

    public void setCr(String cr) {
        this.cr = cr;
    }
}
