package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.psp_RendezVous;
import com.demo.repository.psp_RendezVousRepository;

@Service
public class RendezvousService {

    @Autowired
    private psp_RendezVousRepository Rendezvousrepo;

    public void CreatRendezVous() {

        psp_RendezVous obj = new psp_RendezVous();

        obj.setNomPsp("yassir");
        obj.setAdresse("hy elafarah");
        obj.setStatut(0);
        obj.setTypeRdv(6);
        Rendezvousrepo.save(obj);

    }
}
