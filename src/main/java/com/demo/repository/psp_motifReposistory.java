package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.psp_motif;

public interface psp_motifReposistory extends JpaRepository<psp_motif, Integer> {

    List<psp_motif> findByIdMotif(int idMotif);

    List<psp_motif> findByLibelleM(String libelleM);

    List<psp_motif> findByIdType(int idType);

    List<psp_motif> findByActive(char active);

}
