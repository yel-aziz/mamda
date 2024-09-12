package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.ProspectsProduitsLink;
import com.demo.repository.ProspectsProduitsLinkRepository;

@Service
public class ProspectLinkService {

    @Autowired
    private ProspectsProduitsLinkRepository linkrepo;

    public void deleteprospectlink(int id) {
        ProspectsProduitsLink obj = this.linkrepo.findByProspectProduitLinkId(id);
        this.linkrepo.delete(obj);
    }
}
