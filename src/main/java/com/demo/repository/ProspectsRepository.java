package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.demo.entity.Prospects;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

public interface ProspectsRepository extends JpaRepository<Prospects, Integer> {

    Prospects findByProspectId(Long prospectId);

    List<Prospects> findByUserId(int userId);

    List<Prospects> findAllByUserId(int userId);

    List<Prospects> findByVilleId(int villeId);

    List<Prospects> findByAssureurId(int assureurId);

    List<Prospects> findByReference(String reference);

    List<Prospects> findByDateCreation(Date dateCreation);

    List<Prospects> findByNom(String nom);

    List<Prospects> findByAdresse(String adresse);

    List<Prospects> findByEmail(String email);

    List<Prospects> findByTel(String tel);

    List<Prospects> findByActivite(String activite);

    List<Prospects> findByEffectif(int effectif);

    List<Prospects> findByDirigeant(String dirigeant);

    List<Prospects> findByIntermediaire(String intermediaire);

    List<Prospects> findByCotisation(BigDecimal cotisation);

    List<Prospects> findByRisque(String risque);

    List<Prospects> findByEcheance(Date echeance);

    List<Prospects> findByNomInterlocuteur(String nomInterlocuteur);

    List<Prospects> findByFonctionInterlocuteur(String fonctionInterlocuteur);

    List<Prospects> findByTelInterlocuteur(String telInterlocuteur);

    List<Prospects> findByPlacerAu(int placerAu);

    List<Prospects> findBySuiteProg(String suiteProg);

    List<Prospects> findByNotes(String notes);

    List<Prospects> findByDateMaj(Date dateMaj);

    List<Prospects> findByCloture(String cloture);

    List<Prospects> findByTypePsp(int typePsp);

}
