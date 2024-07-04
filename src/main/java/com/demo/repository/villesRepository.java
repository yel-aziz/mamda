package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.villes;
import java.util.List;

public interface villesRepository extends JpaRepository<villes, Integer> {

    List<villes> findByVilleId(int villeId);

    List<villes> findByLibelle(String libelle);

    List<villes> findByActif(String actif);

}
