package com.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class ProspectDto {

    private String nom;
    private String ville;
    private String assurance;
    private Integer userId;
    private String reference;
    private List<Integer> produits;

    private Integer prospectid;

    private String adresse;

    private String email;

    private String tel;

    private String activite;

    private BigDecimal chiffreAffaire;

    private Integer effectif;

    private String dirigeant;

    private String intermediaire;

    private BigDecimal cotisation;

    private String risque;

    private String nomInterlocuteur;

    private String fonctionInterlocuteur;

    private String telInterlocuteur;

    private Integer placerAu;

    private String suiteProg;

    private String notes;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_maj")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateMaj;

    private String cloture;

    private int typePsp;

    // Getters and setters

    public Integer getPropectId() {
        return prospectid;
    }

    public void setProduits(List<Integer> a) {
        this.produits = a;
    }

    public List<Integer> getProduits() {
        return this.produits;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getVilleId() {
        return ville;
    }

    public void setVilleId(String villeId) {
        this.ville = villeId;
    }

    public String getAssurance() {
        return this.assurance;
    }

    public void setAssurance(String assureurId) {
        this.assurance = assureurId;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getActivite() {
        return activite;
    }

    public void setActivite(String activite) {
        this.activite = activite;
    }

    public BigDecimal getChiffreAffaire() {
        return chiffreAffaire;
    }

    public void setChiffreAffaire(BigDecimal chiffreAffaire) {
        this.chiffreAffaire = chiffreAffaire;
    }

    public int getEffectif() {
        return effectif;
    }

    public void setEffectif(int effectif) {
        this.effectif = effectif;
    }

    public String getDirigeant() {
        return dirigeant;
    }

    public void setDirigeant(String dirigeant) {
        this.dirigeant = dirigeant;
    }

    public String getIntermediaire() {
        return intermediaire;
    }

    public void setIntermediaire(String intermediaire) {
        this.intermediaire = intermediaire;
    }

    public BigDecimal getCotisation() {
        return cotisation;
    }

    public void setCotisation(BigDecimal cotisation) {
        this.cotisation = cotisation;
    }

    public String getRisque() {
        return risque;
    }

    public void setRisque(String risque) {
        this.risque = risque;
    }

    public String getNomInterlocuteur() {
        return nomInterlocuteur;
    }

    public void setNomInterlocuteur(String nomInterlocuteur) {
        this.nomInterlocuteur = nomInterlocuteur;
    }

    public String getFonctionInterlocuteur() {
        return fonctionInterlocuteur;
    }

    public void setFonctionInterlocuteur(String fonctionInterlocuteur) {
        this.fonctionInterlocuteur = fonctionInterlocuteur;
    }

    public String getTelInterlocuteur() {
        return telInterlocuteur;
    }

    public void setTelInterlocuteur(String telInterlocuteur) {
        this.telInterlocuteur = telInterlocuteur;
    }

    public int getPlacerAu() {
        return placerAu;
    }

    public void setPlacerAu(int placerAu) {
        this.placerAu = placerAu;
    }

    public String getSuiteProg() {
        return suiteProg;
    }

    public void setSuiteProg(String suiteProg) {
        this.suiteProg = suiteProg;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getDateMaj() {
        return dateMaj;
    }

    public void setDateMaj(Date dateMaj) {
        this.dateMaj = dateMaj;
    }

    public String getCloture() {
        return cloture;
    }

    public void setCloture(String cloture) {
        this.cloture = cloture;
    }

    public int getTypePsp() {
        return typePsp;
    }

    public void setTypePsp(int typePsp) {
        this.typePsp = typePsp;
    }
}
