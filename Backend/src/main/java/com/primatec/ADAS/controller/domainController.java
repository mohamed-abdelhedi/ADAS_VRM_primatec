package com.primatec.ADAS.controller;

import com.primatec.ADAS.services.domainService;
import com.primatec.ADAS.model.domain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/api/domain")
public class domainController {
    private domainService domainService;

    @Autowired
    public domainController(domainService domainService) {
        this.domainService = domainService;
    }

    @PostMapping("/add")
    public void addDomain(@RequestBody domain domain) {
        domainService.saveDomain(domain);
    }

    @GetMapping("/all")
    public List<domain> getAllDomains() {
        return domainService.getAllDomains();
    }

    @DeleteMapping("/{id}")
    public void deleteDomain(@PathVariable UUID id) {
        domainService.deleteDomain(id);
    }

    @PutMapping("/{id}")
    public domain updateDomain(@PathVariable UUID id, @RequestBody domain updatedDomain) {
        if (!id.equals(updatedDomain.getDomainId())) {
            throw new IllegalArgumentException("Domain id in path variable does not match the id in the request body.");
        }

        return domainService.updateDomain(updatedDomain);
    }

}
