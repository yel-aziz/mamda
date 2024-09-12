package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Produits;

@Repository

public interface ProduitsRepository extends JpaRepository<Produits, Integer> {
    long count();

    List<Produits> findBySociteId(int societe_id);

    List<Produits> findByCode(char code);

    List<Produits> findByLibelle(String libelle);

    List<Produits> findByActif(char actif);

}
