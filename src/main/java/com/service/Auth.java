package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Compagnie;
import com.demo.repository.CompagnieRepository;

@Service
public class Auth {

    @Autowired
    private CompagnieRepository compagnieRepository;

    public List<Compagnie> getIdRepo(String z) {

        return this.compagnieRepository.findByLibelle(z);
    }

}
