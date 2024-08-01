package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.demo.entity.Prospects;
import com.demo.entity.Users;
import com.demo.repository.ProspectsRepository;
import com.demo.repository.UsersRepository;
import com.dto.ProspectDto;

@Service
public class ProspectService {

    @Autowired
    private ProspectsRepository prospectsRepository;
    private UsersRepository userRepository;

    public ProspectService(ProspectsRepository prospectsrepository, UsersRepository userRepository) {
        this.prospectsRepository = prospectsrepository;
        this.userRepository = userRepository;
    }

    public void CreatProspect(int id, ProspectDto obj) {

        Prospects pros = new Prospects(obj);
        System.out.print(obj);

        Users user = userRepository.findByUserId(id);
        pros.setUser(user);
        this.prospectsRepository.save(pros);

    }

    public Prospects getProspects(Long id) {
        return this.prospectsRepository.findByProspectId(id);
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
