package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Users;
import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Integer> {

    Users findByUserId(int userId);


    List<Users> findByInitial(String initial);

    List<Users> findByProfil(String profil);

    Users findByLogin(String login);

    List<Users> findByPassword(String password);

    List<Users> findByActif(String actif);

    List<Users> findByBackOfficeAccess(String backOfficeAccess);

}
