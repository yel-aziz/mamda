package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.psp_Notes;
import java.util.Date;

public interface psp_NotesRepository extends JpaRepository<psp_Notes, Integer> {

    List<psp_Notes> findByIdNote(int idNote);

    List<psp_Notes> findByIdPsp(int idPsp);

    List<psp_Notes> findByNote(String note);

    List<psp_Notes> findByIdUser(int idUser);

    List<psp_Notes> findByDateCreation(Date dateCreation);
}
