package com.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int userId;

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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Prospects> prospects;

    public int getUserId() {
        return userId;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Prospects> getProspects(){
        return this.prospects;
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
}
