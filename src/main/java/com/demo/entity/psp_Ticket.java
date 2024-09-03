package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "psp_Ticket")
public class psp_Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idticket")
    private int idticket;

    @ManyToOne
    @JoinColumn(name = "userticket", nullable = false)
    @JsonBackReference
    private Users user;

    @Column(name = "type")
    private String type;

    @Column(name = "prospectName")
    private String prospectName;

    @Column(length = 100)
    private String motif;

    // Getters and setters

    public int getIdticket() {
        return idticket;
    }

    public void setIdticket(int idticket) {
        this.idticket = idticket;
    }
    public String getIdProspect() {
        return this.prospectName;
    }

    public void setprospectName(String Name) {
        this.prospectName = Name;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String gettype() {
        return type;
    }

    public void settype(String type) {
        this.type = type;
    }

    public String getmotif() {
        return motif;
    }

    public void setmotif(String motif) {
        this.motif = motif;
    }
}
