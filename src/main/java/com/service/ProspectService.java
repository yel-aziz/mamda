package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.entity.Prospects;
import com.demo.entity.users;
import com.demo.repository.ProspectsRepository;
import com.demo.repository.usersRepository;
import com.dto.ProspectDto;

import io.jsonwebtoken.Claims;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;

@Service
public class ProspectService {

    @Autowired
    private ProspectsRepository prospectsRepository;
    private usersRepository userRepository;

    public ProspectService(ProspectsRepository prospectsrepository, usersRepository userRepository) {
        this.prospectsRepository = prospectsrepository;
        this.userRepository = userRepository;
    }

    public void CreatProspect(int id, ProspectDto obj) {

        Prospects pros = new Prospects(obj);
        System.out.print(obj);

       
        users user = userRepository.findByUserId(id);
        pros.setUser(user);
        this.prospectsRepository.save(pros);

    }

    public void updateProspect(Long id, String newName, String target) {
        Prospects existingProspect = prospectsRepository.findByProspectId(id);

        if (existingProspect != null) {
            invokeMethod(target, existingProspect, newName);
        } else {
            throw new RuntimeException("Prospect not found with id: " + id);
        }
    }

    private void invokeMethod(String methodName, Prospects prospect, String newName) {
        try {
            Method method = this.getClass().getDeclaredMethod(methodName, Prospects.class, String.class);
            method.setAccessible(true);
            method.invoke(this, prospect, newName);
        } catch (NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException("Error invoking method " + methodName, e);
        } catch (InvocationTargetException e) {
            // Handle the original cause of the exception
            throw new RuntimeException("Error invoking method " + methodName, e.getCause());
        }
    }

    private void updateNom(Prospects prospect, String newName) {
        prospect.setNom(newName);
        prospectsRepository.save(prospect);
    }

    private void updateAssureurId(Prospects prospect, int newName) {
        prospect.setAssureurId(newName);
        prospectsRepository.save(prospect);
    }

    private void updateAdresse(Prospects prospect, String newName) {
        prospect.setAdresse(newName);
        prospectsRepository.save(prospect);
    }

    private void updateEmail(Prospects prospect, String newName) {
        prospect.setEmail(newName);
        prospectsRepository.save(prospect);
    }

    private void updateTel(Prospects prospect, String newName) {
        prospect.setTel(newName);
        prospectsRepository.save(prospect);
    }

    private void updateActivite(Prospects prospect, String newName) {
        prospect.setActivite(newName);
        prospectsRepository.save(prospect);
    }

    private void updateEffectif(Prospects prospect, int newName) {
        prospect.setEffectif(newName);
        prospectsRepository.save(prospect);
    }

    private void updateDirigeant(Prospects prospect, String newName) {
        prospect.setDirigeant(newName);
        prospectsRepository.save(prospect);
    }

    private void updateIntermediaire(Prospects prospect, String newName) {
        prospect.setIntermediaire(newName);
        prospectsRepository.save(prospect);
    }

    private void updateCotisation(Prospects prospect, BigDecimal newName) {
        prospect.setCotisation(newName);
        prospectsRepository.save(prospect);
    }

    private void updateRisque(Prospects prospect, String newName) {
        prospect.setRisque(newName);
        prospectsRepository.save(prospect);
    }

    private void updateEcheance(Prospects prospect, Date newName) {
        prospect.setEcheance(newName);
        prospectsRepository.save(prospect);
    }

    private void updateNomInterlocuteur(Prospects prospect, String newName) {
        prospect.setNomInterlocuteur(newName);
        prospectsRepository.save(prospect);
    }

    private void updateFonctionInterlocuteur(Prospects prospect, String newName) {
        prospect.setNom(newName);
        prospectsRepository.save(prospect);
    }

    private void updateTelInterlocuteur(Prospects prospect, String newName) {
        prospect.setNom(newName);
        prospectsRepository.save(prospect);
    }

    private void updatePlacerAu(Prospects prospect, String newName) {
        prospect.setNom(newName);
        prospectsRepository.save(prospect);
    }

    private void updateSuiteProg(Prospects prospect, String newName) {
        prospect.setNom(newName);
        prospectsRepository.save(prospect);
    }

    private void updateNotes(Prospects prospect, String newName) {
        prospect.setNom(newName);
        prospectsRepository.save(prospect);
    }

    private void updateDateMaj(Prospects prospect, String newName) {
        prospect.setNom(newName);
        prospectsRepository.save(prospect);
    }

    private void updateCloture(Prospects prospect, String newName) {
        prospect.setNom(newName);
        prospectsRepository.save(prospect);
    }

    private void updateTypePsp(Prospects prospect, String newName) {
        prospect.setNom(newName);
        prospectsRepository.save(prospect);
    }

    public void deleteProspect(int id) {
        this.prospectsRepository.deleteById(id);
    }

}
