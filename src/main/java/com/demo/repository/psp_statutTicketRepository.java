package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.psp_statutTicket;

public interface psp_statutTicketRepository extends JpaRepository<psp_statutTicket, Integer> {

    List<psp_statutTicket> findByIdStatut(int idStatut);

    List<psp_statutTicket> findByLibelleS(String libelleS);
}
