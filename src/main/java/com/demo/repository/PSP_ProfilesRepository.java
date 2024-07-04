package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.PSP_Profiles;

public interface PSP_ProfilesRepository extends JpaRepository<PSP_Profiles, Integer> {

    List<PSP_Profiles> findByProfileId(int profileId);

    List<PSP_Profiles> findByProfileCode(String profileCode);

    List<PSP_Profiles> findByProfileName(String profileName);

    List<PSP_Profiles> findByActif(char actif);

}
