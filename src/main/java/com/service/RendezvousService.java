package com.service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.demo.entity.psp_RendezVous;
import com.demo.entity.Users;
import com.demo.repository.psp_RendezVousRepository;
import com.demo.repository.UsersRepository;

import com.dto.RendezVousDTO;

@Service
public class RendezvousService {

    @Autowired
    private psp_RendezVousRepository Rendezvousrepo;

    @Autowired
    private UsersRepository userRepository;

    public void CreatRendezVous(RendezVousDTO data, int id) {
        psp_RendezVous obj = new psp_RendezVous(data);
        Users user = this.userRepository.findByUserId(id);
        obj.setUser(user);
        this.Rendezvousrepo.save(obj);
    }

    public psp_RendezVous getRendeVous(Long userId) {
        psp_RendezVous rendevous = this.Rendezvousrepo.findByIdRDV(userId);
        return rendevous;
    }

    public  List<psp_RendezVous> getAllRendevous(){
        return this.Rendezvousrepo.findAll();
    }

    public void updateRendevous(psp_RendezVous pro, @ModelAttribute RendezVousDTO obj) {
        pro.update_RendezVous(obj);
        Rendezvousrepo.save(pro);
    }

    public Void DeleteRendezvous(int id) {
        this.Rendezvousrepo.deleteById(id);
        return null;
    }
}
