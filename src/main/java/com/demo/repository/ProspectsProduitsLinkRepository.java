package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.ProspectsProduitsLink;

public interface ProspectsProduitsLinkRepository extends JpaRepository<ProspectsProduitsLink, Integer> {

    List<ProspectsProduitsLink> findByProspectProduitLinkId(int prospectProduitLinkId);

    List<ProspectsProduitsLink> findByProduitId(int produitId);

    List<ProspectsProduitsLink> findByProspectId(int prospectId);
}