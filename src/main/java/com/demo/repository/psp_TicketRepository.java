package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.psp_Ticket;

public interface psp_TicketRepository extends JpaRepository<psp_Ticket, Integer> {

    List<psp_Ticket> findByType(String Type);

    List<psp_Ticket> findByMotif(String motif);
    List<psp_Ticket> findAll();

    psp_Ticket findById(int id);
  

}
