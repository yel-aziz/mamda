package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "prospects_produits_link")
public class ProspectsProduitsLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prospect_produit_link_id")
    private int prospectProduitLinkId;

    @Column(name = "produit_id")
    private Integer produitId;

    @Column(name = "prospect_id")
    private Integer prospectId;


    @ManyToOne
    @JoinColumn(name = "prosid")
    @JsonBackReference
    private Prospects prospect;

    public Integer getProspectId() {
        return this.prospectId;
    }
    public Integer getProspectProduitLinkId() {
        return this.prospectProduitLinkId;
    }
    public Integer setprospectProduitLinkId(int produitId) {
        return this.prospectProduitLinkId = produitId;
    }


    public Prospects getProspect() {
        return prospect;
    }

    public void setProspect(Prospects prospect) {
        this.prospect = prospect;
    }
    // Getters and Setters


    public int getProduitId() {
        return produitId;
    }

    public void setProduitId(int produitId) {
        this.produitId = produitId;
    }

 
    public void setProspectId(Integer prospectId) {
        this.prospectId = prospectId;
    }

}
