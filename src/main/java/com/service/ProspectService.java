package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.demo.entity.Prospects;
import com.demo.entity.ProspectsProduitsLink;
import com.demo.entity.Users;
import com.demo.repository.ProspectsProduitsLinkRepository;
import com.demo.repository.ProspectsRepository;
import com.demo.repository.UsersRepository;
import com.dto.ProspectDto;

@Service
public class ProspectService {

    @Autowired
    private ProspectsRepository prospectsRepository;
    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private ProspectsProduitsLinkRepository prospectlink;

    @Autowired
    private ProspectsProduitsLinkRepository produitrepo;

    public ProspectService(ProspectsRepository prospectsrepository, UsersRepository userRepository) {
        this.prospectsRepository = prospectsrepository;
        this.userRepository = userRepository;
    }

    public Prospects CreatProspect(int id, ProspectDto obj) {
        // Create new Prospects object from DTO
        Prospects pros = new Prospects(obj);
        pros.setUserId(id);

        // Retrieve user and set associated site and user information
        Users user = userRepository.findByUserId(id);
        pros.setSiteId(user.getIDSite());
        pros.setUser(user);
        pros.setNomInterlocuteur(obj.getNomInterlocuteur());
        pros.setFonctionInterlocuteur(obj.getFonctionInterlocuteur());
        pros.setRisque(obj.getRisque());
        pros.setSuiteProg(obj.getSuiteProg());
        pros.setAssurance(obj.getAssurance());

        this.prospectsRepository.save(pros);
        List<Integer> pro = obj.getProduits();

        for (Integer productId : pro) {
            ProspectsProduitsLink produitLink = new ProspectsProduitsLink();
            produitLink.setProduitId(productId);
            produitLink.setProspectId(pros.getProspectId());
            this.produitrepo.save(produitLink);

        }

        return pros;
    }

    public Prospects getProspects(Long id) {
        return this.prospectsRepository.findByProspectId(id);
    }

    public List<ProspectsProduitsLink> getProducts(int id) {
        return this.prospectlink.findByProspectId(id);
    }

    public List<Prospects> getAllProspects() {
        return this.prospectsRepository.findAll();
    }

    public List<Prospects> getAllProspectsByUserId(int id) {
        return this.prospectsRepository.findAllByUserId(id);
    }

    public ResponseEntity<String> updateProspect(Prospects pro, @ModelAttribute ProspectDto obj) {
        pro.ProspectsUpdate(obj);
        prospectsRepository.save(pro);
        return ResponseEntity.ok("updated");

    }

    public void deleteProspect(int id) {
        this.prospectsRepository.deleteById(id);
    }

}
