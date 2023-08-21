package com.primatec.ADAS.services;

import com.primatec.ADAS.DAO.groupDAO;
import com.primatec.ADAS.model.group;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GroupService {

    private final groupDAO groupDAO;

    @Autowired
    public GroupService(groupDAO groupDAO) {
        this.groupDAO = groupDAO;
    }

    public group saveGroup(group group) {
        return groupDAO.save(group);
    }

    public List<group> getAllGroups() {
        return groupDAO.findAll();
    }

    public Optional<group> getGroupById(UUID id) {
        return groupDAO.findById(id);
    }

    public void deleteGroup(UUID id) {
        groupDAO.deleteById(id);
    }

    public group updateGroup(group updatedGroup) {
        Optional<group> optionalGroup = groupDAO.findById(updatedGroup.getGroupId());
        if (optionalGroup.isPresent()) {
            group existingGroup = optionalGroup.get();
            existingGroup.setName(updatedGroup.getName());
            existingGroup.setDomain(updatedGroup.getDomain());
            // Update other fields as needed

            return groupDAO.save(existingGroup);
        } else {
            throw new EntityNotFoundException("Group with id " + updatedGroup.getGroupId() + " not found.");
        }
    }

    // Add additional methods as needed

}
