package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Files;
import java.util.List;
import java.util.Date;

@Repository

public interface FilesRepository extends JpaRepository<Files, Integer> {

    // Find by file name
    List<Files> findByProspectId(int prospectId);

    List<Files> findByFileExtension(String fileExtension);

    List<Files> findByFileName(String fileName);

    List<Files> findByDateCreation(Date dateCreation);

    List<Files> findByUserId(int userId);

    // Find by date creation range
    List<Files> findByDateCreationBetween(Date startDate, Date endDate);

    // Additional methods
}
