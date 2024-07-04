package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.psp_RendezVous;
import java.util.Date;

public interface psp_RendezVousRepository extends JpaRepository<psp_RendezVous, Integer> {

    List<psp_RendezVous> findByIdRDV(int idRDV);

    List<psp_RendezVous> findByIdPsp(int idPsp);

    List<psp_RendezVous> findByNomPsp(String nomPsp);

    List<psp_RendezVous> findByDateRdv(Date dateRdv);

    List<psp_RendezVous> findByHeure(String heure);

    List<psp_RendezVous> findByAdresse(String adresse);

    List<psp_RendezVous> findByDateCreation(Date dateCreation);

    List<psp_RendezVous> findByIdUsers(int idUsers);

    List<psp_RendezVous> findByStatut(int statut);

    List<psp_RendezVous> findByTypeRdv(int typeRdv);

    List<psp_RendezVous> findByCr(String cr);

}
