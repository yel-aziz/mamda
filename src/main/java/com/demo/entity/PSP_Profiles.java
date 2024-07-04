package com.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PSP_Profiles")
public class PSP_Profiles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int profileId;

    @Column(length = 10, nullable = false)
    private String profileCode;

    @Column(length = 100, nullable = false)
    private String profileName;

    @Column(length = 1)
    private char actif;

    // Getters and Setters

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getProfileCode() {
        return profileCode;
    }

    public void setProfileCode(String profileCode) {
        this.profileCode = profileCode;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public char getActif() {
        return actif;
    }

    public void setActif(char actif) {
        this.actif = actif;
    }
}
