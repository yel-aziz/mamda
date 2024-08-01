package com.dto;

public class psp_TicketDto {

    private int idType;
    private String libelleT;
    private char active;

    // Getters and setters
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
