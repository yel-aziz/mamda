package com.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "psp_statutTicket")
public class psp_statutTicket {

    @Id
    private int idStatut;

    @Column(length = 50)
    private String libelleS;


    public int getIdStatut() {
        return idStatut;
    }

    public void setIdStatut(int idStatut) {
        this.idStatut = idStatut;
    }

    public String getLibelleS() {
        return libelleS;
    }

    public void setLibelleS(String libelleS) {
        this.libelleS = libelleS;
    }
}
