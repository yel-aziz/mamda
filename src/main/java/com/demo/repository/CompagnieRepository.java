package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Compagnie;
import java.util.List;

@Repository

public interface CompagnieRepository extends JpaRepository<Compagnie, Integer> {

    // Custom query methods
    // Find all active companies
    List<Compagnie> findByCompanieId(int companieId);

    List<Compagnie> findByActif(String actif);

    List<Compagnie> findByLibelle(String libelle);

   

}
