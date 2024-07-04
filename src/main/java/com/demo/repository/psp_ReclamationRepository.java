package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.psp_Reclamation;
import java.util.Date;

public interface psp_ReclamationRepository extends JpaRepository<psp_Reclamation, Integer> {

    List<psp_Reclamation> findByIdReclamation(int idReclamation);

    List<psp_Reclamation> findByIdUser(int idUser);

    List<psp_Reclamation> findByIdProspect(int idProspect);

    List<psp_Reclamation> findByReclamation(String reclamation);

    List<psp_Reclamation> findByDateReclamation(Date dateReclamation);

    List<psp_Reclamation> findByIdType(int idType);

    List<psp_Reclamation> findByIdMotif(int idMotif);

    List<psp_Reclamation> findByIdSite(int idSite);

    List<psp_Reclamation> findByIdStatut(int idStatut);

    List<psp_Reclamation> findByPriorite(char priorite);

}
