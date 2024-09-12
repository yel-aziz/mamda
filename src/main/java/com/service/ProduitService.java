package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.demo.entity.Produits;
import com.demo.repository.ProduitsRepository;

@Service
public class ProduitService {

    @Autowired
    private ProduitsRepository productrepo;

    public void CreatProduct() {
        Produits product = new Produits();
        product.setActif('a');
        product.setCode('r');
        product.setSocieteId(21);
        product.setLibelle("azerty");

        productrepo.save(product);
    }

}
