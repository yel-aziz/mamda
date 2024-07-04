package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.ProspectsCloture;
import java.math.BigDecimal;
import java.util.Date;

public interface ProspectsClotureRepository extends JpaRepository<ProspectsCloture, Integer> {

    List<ProspectsCloture> findByIdProspectCloture(int idProspectCloture);

    List<ProspectsCloture> findByIdProspect(int idProspect);

    List<ProspectsCloture> findBySortProspect(int sortProspect);

    List<ProspectsCloture> findByCaRealise(BigDecimal caRealise);

    List<ProspectsCloture> findByPoliceAIS(String policeAIS);

    List<ProspectsCloture> findByDateCloture(Date dateCloture);

    List<ProspectsCloture> findByIdUserCloture(int idUserCloture);

}
