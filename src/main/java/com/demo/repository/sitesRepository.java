package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.sites;
import java.util.List;

public interface sitesRepository extends JpaRepository<sites, Integer> {

    List<sites> findBySiteId(int siteId);

    List<sites> findByLibelle(String libelle);

    List<sites> findByActif(String actif);

}
