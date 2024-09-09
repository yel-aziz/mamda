package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.demo.entity.Prospects;
import com.demo.entity.Produits;
import com.demo.entity.ProspectsProduitsLink;
import com.demo.entity.Users;
import com.demo.repository.ProduitsRepository;
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
    private ProduitsRepository produitrepo;

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
            // Retrieve existing product or create new product entity
            ProspectsProduitsLink produit = new ProspectsProduitsLink();

            produit.setProspect(pros);

            produit.setProspectId(pros.getProspectId()); // Save the Product entity
            this.prospectlink.save(produit);
        }

        return pros;
    }

    public Prospects getProspects(Long id) {
        return this.prospectsRepository.findByProspectId(id);
    }

    public List<Prospects> getAllProspects() {
        return this.prospectsRepository.findAll();
    }

    public List<Prospects> getAllProspectsByUserId(int id) {
        return this.prospectsRepository.findAllByUserId(id);
    }

    public ResponseEntity<?> updateProspect(Prospects pro, @ModelAttribute ProspectDto obj) {
        List<Integer> prod = obj.getProduits();
        List<ProspectsProduitsLink> existingProducts = pro.getProduits();

        return ResponseEntity.ok(existingProducts);

    }

    public void deleteProspect(int id) {
        this.prospectsRepository.deleteById(id);
    }

}
