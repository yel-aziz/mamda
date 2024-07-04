package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.users;
import java.util.List;

public interface usersRepository extends JpaRepository<users, Integer> {

    users findByUserId(int userId);


    List<users> findByInitial(String initial);

    List<users> findByProfil(String profil);

    users findByLogin(String login);

    List<users> findByPassword(String password);

    List<users> findByActif(String actif);

    List<users> findByBackOfficeAccess(String backOfficeAccess);

}
