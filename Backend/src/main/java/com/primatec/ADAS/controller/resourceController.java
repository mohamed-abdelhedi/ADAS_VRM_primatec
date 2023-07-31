package com.primatec.ADAS.controller;

import com.primatec.ADAS.services.resourceServices;
import com.primatec.ADAS.model.resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/resource")
public class resourceController {
    private resourceServices resourceServices;

    @Autowired
    public void resourceController(resourceServices resourceServices) {
        this.resourceServices = resourceServices;
    }

    @PostMapping("/add")
    public void addResource(@RequestBody resource resource) {
        resourceServices.saveResource(resource);
    }

    @GetMapping("/all")
    public List<resource> getAllResources() {
        return resourceServices.getAllResources();
    }

    @DeleteMapping("/{id}")
    public void deleteResource(@PathVariable UUID id) {
        resourceServices.deleteResource(id);
    }

    @PutMapping("/{id}")
    public resource updateResource(@PathVariable UUID id, @RequestBody resource updatedResource) {
        // Ensure the id in the request body matches the path variable id
        if (!id.equals(updatedResource.getResource_id())) {
            throw new IllegalArgumentException("Resource id in path variable does not match the id in the request body.");
        }

        return resourceServices.updateResource(updatedResource);
    }
}
