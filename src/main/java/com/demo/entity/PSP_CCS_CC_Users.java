package com.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PSP_CCS_CC_Users")
public class PSP_CCS_CC_Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUserProfil;

    private int idCcsUser;

    private int idCcUser;


    public int getIdUserProfil() {
        return idUserProfil;
    }

    public void setIdUserProfil(int idUserProfil) {
        this.idUserProfil = idUserProfil;
    }

    public int getIdCcsUser() {
        return idCcsUser;
    }

    public void setIdCcsUser(int idCcsUser) {
        this.idCcsUser = idCcsUser;
    }

    public int getIdCcUser() {
        return idCcUser;
    }

    public void setIdCcUser(int idCcUser) {
        this.idCcUser = idCcUser;
    }
}
