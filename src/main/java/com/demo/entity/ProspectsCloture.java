package com.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "prospects_cloture")
public class ProspectsCloture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProspectCloture;

    private int idProspect;

    private int sortProspect;

    @Column(precision = 19, scale = 2)
    private BigDecimal caRealise;

    @Column(length = 50)
    private String policeAIS;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCloture;

    private int idUserCloture;


    public int getIdProspectCloture() {
        return idProspectCloture;
    }

    public void setIdProspectCloture(int idProspectCloture) {
        this.idProspectCloture = idProspectCloture;
    }

    public int getIdProspect() {
        return idProspect;
    }

    public void setIdProspect(int idProspect) {
        this.idProspect = idProspect;
    }

    public int getSortProspect() {
        return sortProspect;
    }

    public void setSortProspect(int sortProspect) {
        this.sortProspect = sortProspect;
    }

    public BigDecimal getCaRealise() {
        return caRealise;
    }

    public void setCaRealise(BigDecimal caRealise) {
        this.caRealise = caRealise;
    }

    public String getPoliceAIS() {
        return policeAIS;
    }

    public void setPoliceAIS(String policeAIS) {
        this.policeAIS = policeAIS;
    }

    public Date getDateCloture() {
        return dateCloture;
    }

    public void setDateCloture(Date dateCloture) {
        this.dateCloture = dateCloture;
    }

    public int getIdUserCloture() {
        return idUserCloture;
    }

    public void setIdUserCloture(int idUserCloture) {
        this.idUserCloture = idUserCloture;
    }
}
