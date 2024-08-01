package com.demo.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "Sites")
public class Sites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "siteId")
    private int siteId;

    @Column(length = 50, nullable = false)
    private String libelle;

    @Column(length = 50, nullable = false)
    private String region;

    @Column(length = 1, nullable = false)
    private String actif;

    @OneToMany(mappedBy = "site", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Users> users = new ArrayList<>();

    // Getters and setters

    public int getSiteId() {
        return siteId;
    }
    
    public void setUsers(List<Users> users) {
        this.users = users;
    }
    public void setregion(String region) {
        this.region = region;
    }

    public String getregion() {
        return this.region;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }
    public List<Users> getUsers() {
        return this.users;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getActif() {
        return actif;
    }

    public void setActif(String actif) {
        this.actif = actif;
    }

}
