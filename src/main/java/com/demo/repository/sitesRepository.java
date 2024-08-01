package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Sites;
import java.util.List;

public interface SitesRepository extends JpaRepository<Sites, Integer> {

    Sites findBySiteId(int siteId);

    List<Sites> findByLibelle(String libelle);

    List<Sites> findByActif(String actif);

    List<Sites> findByRegion(String Region);
 
    List<Sites> findAll();

}
