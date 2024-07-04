package com.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "prospects_produits_link")
public class ProspectsProduitsLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prospectProduitLinkId;

    private int produitId;

    private int prospectId;


    public int getProspectProduitLinkId() {
        return prospectProduitLinkId;
    }

    public void setProspectProduitLinkId(int prospectProduitLinkId) {
        this.prospectProduitLinkId = prospectProduitLinkId;
    }

    public int getProduitId() {
        return produitId;
    }

    public void setProduitId(int produitId) {
        this.produitId = produitId;
    }

    public int getProspectId() {
        return prospectId;
    }

    public void setProspectId(int prospectId) {
        this.prospectId = prospectId;
    }
}
