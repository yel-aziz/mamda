package com.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.entity.Compagnie;
import com.demo.repository.CompagnieRepository;

@Service

public class CompagnieService {

    @Autowired
    private CompagnieRepository compagnieRepository;

    public List<Compagnie> getAllCompagnies() {
        return this.compagnieRepository.findAll();
    }

    public void CreatCompanie(String Status, String Libelle) {

        Compagnie obj = new Compagnie();

        obj.setActif(Status);
        obj.setLibelle(Libelle);
        compagnieRepository.save(obj);

        return;
    }

    public Compagnie getCompagnieById(Long id) {

        return this.compagnieRepository.findByCompanieId(id);
    }

    public List<Compagnie> getCompagnieByLibelle(String libelle) {
        return this.compagnieRepository.findByLibelle(libelle);
    }

    public void updateLibelle(String Libelle, Long id) {

        Compagnie obj = this.getCompagnieById(id);

        obj.setLibelle(Libelle);
        compagnieRepository.save(obj);
    }

    public void updateStatus(String status, Long id) {

        Compagnie obj = this.getCompagnieById(id);

        obj.setActif(status);
        compagnieRepository.save(obj);
    }

}
