package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.psp_Evenement;
import java.util.Date;

public interface psp_EvenementRepository extends JpaRepository<psp_Evenement, Integer> {
    List<psp_Evenement> findByIdEve(int idEve);

    List<psp_Evenement> findByIdPsp(int idPsp);

    List<psp_Evenement> findByNomPsp(String nomPsp);

    List<psp_Evenement> findByIdEvtype(int idEvtype);

    List<psp_Evenement> findByDateCreation(Date dateCreation);

    List<psp_Evenement> findByIdUsers(int idUsers);
}
