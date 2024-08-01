package com.dto;

public class ReclamationDto {
    private int idUser;
    private int idProspect;
    private String reclamation;
    private int type;
    private int motif;
    private int idSite;
    private int idStatut;
    private char priorite;

    // Getters and setters
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getMotif() {
        return motif;
    }

    public void setMotif(int motif) {
        this.motif = motif;
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
