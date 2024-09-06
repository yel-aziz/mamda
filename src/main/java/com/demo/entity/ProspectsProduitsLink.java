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
    private int produitId;

    @Column(name = "prospect_id")
    private Long prospectId;


    // Getters and Setters


    public int getProduitId() {
        return produitId;
    }

    public void setProduitId(int produitId) {
        this.produitId = produitId;
    }

    public Long getProspectId() {
        return prospectId;
    }

    public void setProspectId(Long prospectId) {
        this.prospectId = prospectId;
    }

}
