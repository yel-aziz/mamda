package com.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.demo.entity.Prospects;
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
            produit.setProduitId(productId);

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

    public List<ProspectsProduitsLink> getAllProductsProspect(int id) {
        return this.prospectlink.findByProspectId(id);
    }

    public void deleteprospectlink(int id) {
        this.prospectlink.deleteById(id);
    }

    public List<Integer> updateProspect(Prospects pro, @ModelAttribute ProspectDto obj) {

        List<Integer> newProductIds = obj.getProduits();
        List<ProspectsProduitsLink> existingProducts = pro.getProduits();
        List<Integer> existingProductIds = new ArrayList<>();
        pro.ProspectsUpdate(obj);

        // Collect existing product IDs
        for (ProspectsProduitsLink link : existingProducts) {
            existingProductIds.add(link.getProduitId());
        }

        List<Integer> productsToAdd = new ArrayList<>();
        List<Integer> productsToRemove = new ArrayList<>();

        // Determine products to add
        for (Integer newProductId : newProductIds) {
            if (!existingProductIds.contains(newProductId)) {
                productsToAdd.add(newProductId);
            }
        }

        // Add new products
        for (Integer productIdToAdd : productsToAdd) {
            ProspectsProduitsLink newLink = new ProspectsProduitsLink();
            newLink.setProspectId(pro.getProspectId());
            newLink.setProspect(pro);
            newLink.setProduitId(productIdToAdd);
            this.prospectlink.save(newLink);
        }

        // Determine products to remove
        for (Integer existingProductId : existingProductIds) {
            if (!newProductIds.contains(existingProductId)) {
                productsToRemove.add(existingProductId);
            }
        }

        // Identify which product links to remove and remove them from the collection
        List<ProspectsProduitsLink> linksToRemove = new ArrayList<>();
        for (ProspectsProduitsLink link : existingProducts) {
            Integer produitId = link.getProduitId();
            if (productsToRemove.contains(produitId)) {
                linksToRemove.add(link); // Mark for removal
            }
        }

        // Remove orphans from the collection
        existingProducts.removeAll(linksToRemove);

        // Save the updated state
        this.prospectsRepository.save(pro);

        // Debugging output
        System.out.println("Products to Add: " + productsToAdd);
        System.out.println("Products to Remove: " + productsToRemove);

        return productsToRemove;
    }

    public void deleteProspect(int id) {
        this.prospectsRepository.deleteById(id);
    }

}
