package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.psp_TypeEvenement;
import java.util.List;

public interface psp_TypeEvenementRepository extends JpaRepository<psp_TypeEvenement, Integer> {

    List<psp_TypeEvenement> findByIdEvtype(int idEvtype);

    List<psp_TypeEvenement> findByLibelle(String libelle);

    List<psp_TypeEvenement> findByCodeType(String codeType);

}
