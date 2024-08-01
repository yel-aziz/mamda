package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.psp_Ticket;
import com.demo.entity.Users;
import com.demo.repository.psp_TicketRepository;
import com.dto.psp_TicketDto;

@Service
public class TicketService {

    @Autowired
    private psp_TicketRepository psp_TicketRepository;

    public void creatTicket(psp_TicketDto data,Users user) {
        psp_Ticket obj = new psp_Ticket();
        obj.setLibelleT(data.getLibelleT());
        obj.setIdType(data.getIdType());
        obj.setActive(data.getActive());
        obj.setUser(user);
        psp_TicketRepository.save(obj);

    }

    public void UpdateTicket(psp_TicketDto data, int id) {
        psp_Ticket obj = this.psp_TicketRepository.findById(id);
        obj.setLibelleT(data.getLibelleT());
        obj.setIdType(data.getIdType());
        obj.setActive(data.getActive());
        psp_TicketRepository.save(obj);

    }

    public void deletTicket(int id) {
        this.psp_TicketRepository.deleteById(id);
    }

}
