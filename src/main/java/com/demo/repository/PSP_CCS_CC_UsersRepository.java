package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.PSP_CCS_CC_Users;
import java.util.List;

public interface PSP_CCS_CC_UsersRepository extends JpaRepository<PSP_CCS_CC_Users, Integer> {

    List<PSP_CCS_CC_Users> findByIdUserProfil(int idUserProfil);

    List<PSP_CCS_CC_Users> findByIdCcUser(int idCcUser);

    List<PSP_CCS_CC_Users> findByIdCcsUser(int idCcsUser);
}
