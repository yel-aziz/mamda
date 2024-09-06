package com.demo.entity;

import com.dto.ProspectDto;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "prospects")
public class Prospects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prospectId")
    private Long prospectId;

    @Column(name = "userId")
    private int userId;

    @Column(name = "siteId")
    private int siteId;

    @Column(name = "ville")
    private String ville;

    @Column(name = "assurenceactuel")
    private String assurenceactuel;

    @Column(name = "reference", length = 50)
    private String reference;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateCreation")
    private Date dateCreation;

    @Column(name = "nom", length = 150)
    private String nom;

    @Column(name = "adresse", length = 500)
    private String adresse;

    @Column(name = "email", length = 150)
    private String email;

    @Column(name = "tel", length = 20)
    private String tel;

    @Column(name = "activite", length = 500)
    private String activite;

    @Column(precision = 19, scale = 2)
    private BigDecimal chiffreAffaire;

    @Column(name = "effectif")
    private int effectif;

    @Column(name = "dirigeant", length = 150)
    private String dirigeant;

    @Column(name = "intermediaire", length = 150)
    private String intermediaire;

    @Column(name = "cotisation", precision = 19, scale = 2)
    private BigDecimal cotisation;

    @Column(name = "risque", length = 250)
    private String risque;

    @Temporal(TemporalType.TIMESTAMP)
    private Date echeance;

    @Column(name = "nomInterlocuteur", length = 150)
    private String nomInterlocuteur;

    @Column(name = "fonctionInterlocuteur", length = 150)
    private String fonctionInterlocuteur;

    @Column(name = "telInterlocuteur", length = 20)
    private String telInterlocuteur;

    private int placerAu;

    @ManyToOne
    @JoinColumn(name = "userprospect", nullable = false)
    @JsonBackReference
    private Users user;

    @Column(name = "suiteProg", length = 150)
    private String suiteProg;

    @Column(name = "notes", length = 500)
    private String notes;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateMaj;

    @Column(name = "cloture", length = 1)
    private String cloture;

    @Column(name = "typePsp", length = 1)
    private int typePsp;

    public Prospects() {

    }

    public Prospects(ProspectDto obj) {

        this.setNom(obj.getNom());
        this.setAdresse(obj.getAdresse());
        this.setEmail(obj.getEmail());
        this.setTel(obj.getTel());
        this.setActivite(obj.getActivite());
        this.setChiffreAffaire(obj.getChiffreAffaire());
        this.setEffectif(obj.getEffectif());
        this.setDirigeant(obj.getDirigeant());
        this.setIntermediaire(obj.getIntermediaire());
        this.setCotisation(obj.getCotisation());
        this.setRisque(obj.getRisque());
        this.setFonctionInterlocuteur(obj.getFonctionInterlocuteur());
        this.setTelInterlocuteur(obj.getTelInterlocuteur());
        this.setPlacerAu(obj.getPlacerAu());
        this.setSuiteProg(obj.getSuiteProg());
        this.setNotes(obj.getNotes());
        this.setCloture(obj.getCloture());
        this.setTypePsp(obj.getTypePsp());
        this.setDateCreation(new Date());
    }

    public void ProspectsUpdate(ProspectDto obj) {

        this.setNom(obj.getNom());
        this.setAdresse(obj.getAdresse());
        this.setEmail(obj.getEmail());
        this.setTel(obj.getTel());
        this.setActivite(obj.getActivite());
        this.setChiffreAffaire(obj.getChiffreAffaire());
        this.setEffectif(obj.getEffectif());
        this.setDirigeant(obj.getDirigeant());
        this.setIntermediaire(obj.getIntermediaire());
        this.setCotisation(obj.getCotisation());
        this.setRisque(obj.getRisque());
        this.setFonctionInterlocuteur(obj.getFonctionInterlocuteur());
        this.setTelInterlocuteur(obj.getTelInterlocuteur());
        this.setPlacerAu(obj.getPlacerAu());
        this.setSuiteProg(obj.getSuiteProg());
        this.setNotes(obj.getNotes());
        this.setCloture(obj.getCloture());
        this.setTypePsp(obj.getTypePsp());
        this.setAssurance(obj.getAssurance());

    }

    public Long getProspectId() {
        return prospectId;
    }


    public void setProspectId(Long prospectId) {
        this.prospectId = prospectId;
    }

    public void setSiteId(int id) {
        this.siteId = id;
    }

    public int getSiteById() {
        return this.siteId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Users getUser() {
        return this.user;
    }

    public void setUser(Users obj) {
        this.user = obj;
    }

    public String getVilleId() {
        return ville;
    }

    public void setVilleId(String ville) {
        this.ville = ville;
    }

    public String  getAssurance() {
        return assurenceactuel;
    }

    public void setAssurance(String assureur) {
        this.assurenceactuel = assureur;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
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

    public Date getEcheance() {
        return echeance;
    }

    public void setEcheance(Date echeance) {
        this.echeance = echeance;
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
