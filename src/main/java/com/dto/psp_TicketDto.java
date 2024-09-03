package com.dto;

public class psp_TicketDto {

    private String motif;
    private String type;
    private String prospectName;

    // Getters and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getprospectName() {
        return this.prospectName;
    }

    public void setprospectName(String name) {
        this.prospectName = name;
    }

    public String getmotif() {
        return motif;
    }

    public void setmotif(String motif) {
        this.motif = motif;
    }

}
