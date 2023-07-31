package com.primatec.ADAS.services;

import com.primatec.ADAS.DAO.resourceDAO;

import com.primatec.ADAS.model.resource;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class resourceServices {
    private final resourceDAO resourceDAO;

    @Autowired
    public resourceServices(resourceDAO resourceDAO) {
        this.resourceDAO = resourceDAO;
    }

    public void saveResource(resource resource) {
        resourceDAO.save(resource);
    }

    public List<resource> getAllResources() {
        return resourceDAO.findAll();
    }

    public Optional<resource> getResourceById(UUID id) {
        return resourceDAO.findById(id);
    }

    public void deleteResource(UUID id) {
        resourceDAO.deleteById(id);
    }

    public resource updateResource(resource updatedResource) {
        // Check if the resource exists in the database
        Optional<resource> optionalResource = resourceDAO.findById(updatedResource.getResource_id());
        if (optionalResource.isPresent()) {
            // Update the existing resource with the new data
            resource existingResource = optionalResource.get();
            existingResource.setName(updatedResource.getName());
            existingResource.setDescription(updatedResource.getDescription());
            existingResource.setNumberOfUsage(updatedResource.getNumberOfUsage());
            existingResource.setDateOfPurchasing(updatedResource.getDateOfPurchasing());
            existingResource.setReference(updatedResource.getReference());
            existingResource.setAvailability(updatedResource.isAvailability());
            existingResource.setOther_info(updatedResource.getOther_info());

            // Save the updated resource to the database
            return resourceDAO.save(existingResource);
        } else {
            // Resource not found, throw an exception or handle the error accordingly
            throw new EntityNotFoundException("Resource with id " + updatedResource.getResource_id() + " not found.");
        }
    }
    public List<resource> getResourcesByTeamId(UUID teamId) {
        return resourceDAO.findByTeamTeam_id(teamId);
    }
}

