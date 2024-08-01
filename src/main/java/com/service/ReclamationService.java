package com.service;



import com.demo.entity.psp_Reclamation;
import com.demo.repository.psp_ReclamationRepository;
import com.dto.ReclamationDto;

public class ReclamationService {

    psp_ReclamationRepository reclamationRepository;

    public void CreatReclmation(int idUser, int idProspect, String reclamation,
            int type, int motif, int idSite, int idStatut, char priorite) {

        psp_Reclamation obj = new psp_Reclamation();
        obj.setIdUser(0);
        obj.setIdProspect(0);
        obj.setReclamation(null);
        obj.setIdType(0);
        obj.setIdMotif(0);
        obj.setIdSite(0);
        obj.setIdStatut(0);
        obj.setPriorite('a');
        reclamationRepository.save(obj);
    }

    public void updateReclamation(ReclamationDto data, Long id) {

        psp_Reclamation obj = this.reclamationRepository.findByIdReclamation(id);
        obj.setIdUser(obj.getIdUser());
        obj.setIdProspect(obj.getIdProspect());
        obj.setReclamation(obj.getReclamation());
        obj.setIdType(obj.getIdType());
        obj.setIdMotif(obj.getIdMotif());
        obj.setIdSite(obj.getIdSite());
        obj.setIdStatut(obj.getIdStatut());
        obj.setPriorite(obj.getPriorite());
        reclamationRepository.save(obj);

    }

    public void dateReclamation(int id) {
        this.reclamationRepository.deleteById(id);
    }

}
