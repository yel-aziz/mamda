package com.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int userId;

    @Column(name = "idsite")
    private int idsite;

    @Column(name = "FullName")
    private String FullName;

    @Column(name = "Email")
    private String Email;

    @Column(name = "PhoneNumber")
    private String PhoneNumber;

    @Column(length = 150)
    private String username;

    @Column(length = 3)
    private String initial;

    @Column(length = 1)
    private String profil;

    @Column(length = 50)
    private String login;

    @Column(length = 128)
    private String password;

    @Column(length = 1)
    private String actif;

    @Column(length = 1)
    private String backOfficeAccess;

    @Column(name = "Role")
    private String role;

    @ManyToOne
    @JoinColumn(name = "Profile_Id", referencedColumnName = "profileId")
    private PSP_Profiles profile;

    private int bureau;

    private String Region;

    @ManyToOne
    @JoinColumn(name = "site_id")
    @JsonBackReference
    private Sites site;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<psp_Ticket> tickets;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Prospects> prospects;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<psp_RendezVous> rendezvous;

    // Getters and setters

    public int getUserId() {
        return userId;
    }

    public void setSites(Sites site) {
        this.site = site;
    }

    public String getEmail() {
        return this.Email;
    }

    public String getFullName() {
        return this.FullName;
    }

    public void setFullName(String fullname) {
        this.FullName = fullname;
    }

    public String getPhoneNumber() {
        return this.PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setidsite(int site) {
        this.idsite = site;
    }

    public int getIDSite() {
        return this.idsite;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public String getRegion() {
        return this.Region;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getActif() {
        return actif;
    }

    public void setActif(String actif) {
        this.actif = actif;
    }

    public String getBackOfficeAccess() {
        return backOfficeAccess;
    }

    public void setBackOfficeAccess(String backOfficeAccess) {
        this.backOfficeAccess = backOfficeAccess;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public PSP_Profiles getProfile() {
        return profile;
    }

    public void setProfile(PSP_Profiles profile) {
        this.profile = profile;
    }

    public int getBureau() {
        return bureau;
    }

    public void setBureau(int bureau) {
        this.bureau = bureau;
    }

    public List<psp_Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<psp_Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Prospects> getProspects() {
        return prospects;
    }

    public void setProspects(List<Prospects> prospects) {
        this.prospects = prospects;
    }

    public List<psp_RendezVous> getRendezvous() {
        return rendezvous;
    }

    public void setRendezvous(List<psp_RendezVous> rendezvous) {
        this.rendezvous = rendezvous;
    }
}
