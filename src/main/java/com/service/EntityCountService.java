
package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.repository.*;
import com.demo.repository.UsersRepository;
import com.dto.EntityCountDTO;

@Service
public class EntityCountService {

    @Autowired
    private ProspectsRepository prospectRepository;

    @Autowired
    private UsersRepository userRepository;

    public EntityCountDTO getEntityCounts() {
        long prospectCount = prospectRepository.count();

        long userCount = userRepository.count();

        return new EntityCountDTO(prospectCount, userCount);
    }

}
