package com.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.psp_Ticket;
import com.demo.entity.Users;
import com.demo.repository.psp_TicketRepository;
import com.dto.psp_TicketDto;

@Service
public class TicketService {

    @Autowired
    private psp_TicketRepository psp_ticketrepo;

    public void creatTicket(psp_TicketDto data, Users user) {
        psp_Ticket obj = new psp_Ticket();
        obj.setmotif(data.getmotif());
        obj.settype(data.getType());
        obj.setprospectName(data.getprospectName());
        obj.setUser(user);
        psp_ticketrepo.save(obj);

    }

    public void UpdateTicket(psp_TicketDto data, int id) {
        psp_Ticket obj = this.psp_ticketrepo.findById(id);
        obj.setmotif(data.getmotif());
        obj.settype(data.getType());
        psp_ticketrepo.save(obj);
    }

    public List<psp_Ticket> getAll(){
        return this.psp_ticketrepo.findAll();
    }

    public void deletTicket(int id) {
       this.psp_ticketrepo.deleteById(id);
    }

}
