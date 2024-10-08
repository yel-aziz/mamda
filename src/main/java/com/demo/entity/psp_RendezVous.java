package com.demo.entity;

import jakarta.persistence.*;
import java.util.Date;

import com.dto.RendezVousDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "psp_RendezVous")
public class psp_RendezVous {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRDV;

    private int idPsp;

    @Column(length = 500)
    private String nomPsp;

    private Date dateRdv;

    @Column(length = 6)
    private String heure;

    @Column(length = 500)
    private String adresse;

    @Temporal(TemporalType.DATE)
    private Date dateCreation;

    @ManyToOne
    @JoinColumn(name = "userendezvous", nullable = false)
    @JsonBackReference
    private Users user;

    private int statut;

    private int typeRdv;

    @Column(columnDefinition = "TEXT")
    private String cr;

    public psp_RendezVous() {

    }

    public psp_RendezVous(RendezVousDTO obj) {

        this.setIdRDV(obj.getIdRDV());
        this.setIdPsp(obj.getIdPsp());
        this.setNomPsp(obj.getNomPsp());
        this.setDateRdv(obj.getDateRdv());
        this.setHeure(obj.getHeure());
        this.setAdresse(obj.getAdresse());
        this.setDateCreation(obj.getDateCreation());
        this.setStatut(obj.getStatut());
        this.setTypeRdv(obj.getTypeRdv());
        this.setCr(obj.getCr());
    }

    public void update_RendezVous(RendezVousDTO obj) {

        this.setIdPsp(obj.getIdPsp());
        this.setNomPsp(obj.getNomPsp());
        this.setDateRdv(obj.getDateRdv());
        this.setHeure(obj.getHeure());
        this.setAdresse(obj.getAdresse());
        this.setDateCreation(obj.getDateCreation());
        this.setStatut(obj.getStatut());
        this.setTypeRdv(obj.getTypeRdv());
        this.setCr(obj.getCr());
    }


    public int getIdRDV() {
        return idRDV;
    }

    public void setIdRDV(int idRDV) {
        this.idRDV = idRDV;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Users getUser(){
        return this.user;
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
