package com.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "psp_TypeEvenement")
public class psp_TypeEvenement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEvtype;

    @Column(length = 500)
    private String libelle;

    @Column(length = 2)
    private String codeType;


    public int getIdEvtype() {
        return idEvtype;
    }

    public void setIdEvtype(int idEvtype) {
        this.idEvtype = idEvtype;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }
}
