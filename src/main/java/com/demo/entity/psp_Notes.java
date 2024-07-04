package com.demo.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "psp_Notes")
public class psp_Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNote;

    private int idPsp;

    @Column(length = 1000)
    private String note;

    private int idUser;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

    // Getters and Setters

    public int getIdNote() {
        return idNote;
    }

    public void setIdNote(int idNote) {
        this.idNote = idNote;
    }

    public int getIdPsp() {
        return idPsp;
    }

    public void setIdPsp(int idPsp) {
        this.idPsp = idPsp;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
}
