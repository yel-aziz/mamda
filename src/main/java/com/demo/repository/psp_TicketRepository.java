package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.psp_Ticket;

public interface psp_TicketRepository extends JpaRepository<psp_Ticket, Integer> {

    List<psp_Ticket> findByIdType(int idType);

    List<psp_Ticket> findByLibelleT(String libelleT);

    List<psp_Ticket> findByActive(char active);

}
