package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.ProspectsProduitsLink;

public interface ProspectsProduitsLinkRepository extends JpaRepository<ProspectsProduitsLink, Integer> {

    ProspectsProduitsLink findByProspectProduitLinkId(int prospectProduitLinkId);

    ProspectsProduitsLink findByProspectIdAndProduitId(Integer id, Integer produitid);

    List<ProspectsProduitsLink> findByProduitId(int produitId);

    List<ProspectsProduitsLink> findByProspectId(Integer prospectId);

}