package com.primatec.ADAS.services;

import com.primatec.ADAS.DAO.domainDAO;
import com.primatec.ADAS.model.domain;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class domainService {
    private final domainDAO domainDAO;

    @Autowired
    public domainService(domainDAO domainDAO) {
        this.domainDAO = domainDAO;
    }

    public void saveDomain(domain domain) {
        domainDAO.save(domain);
    }

    public List<domain> getAllDomains() {
        return domainDAO.findAll();
    }

    public Optional<domain> getDomainById(UUID id) {
        return domainDAO.findById(id);
    }

    public void deleteDomain(UUID id) {
        domainDAO.deleteById(id);
    }

    public domain updateDomain(domain updatedDomain) {
        Optional<domain> optionalDomain = domainDAO.findById(updatedDomain.getDomainId());
        if (optionalDomain.isPresent()) {
            domain existingDomain = optionalDomain.get();
            existingDomain.setName(updatedDomain.getName());
            // Add more fields to update as needed

            return domainDAO.save(existingDomain);
        } else {
            throw new EntityNotFoundException("Domain with id " + updatedDomain.getDomainId() + " not found.");
        }
    }

    // You can add more methods as needed for your use case
}
