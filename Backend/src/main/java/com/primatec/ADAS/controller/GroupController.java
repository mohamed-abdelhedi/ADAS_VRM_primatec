package com.primatec.ADAS.controller;

import com.primatec.ADAS.model.group;
import com.primatec.ADAS.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/api/groups")
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping("/add")
    public group addGroup(@RequestBody group group) {
        return groupService.saveGroup(group);
    }

    @GetMapping("/all")
    public List<group> getAllGroups() {
        return groupService.getAllGroups();
    }

    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable UUID id) {
        groupService.deleteGroup(id);
    }

    @PutMapping("/{id}")
    public group updateGroup(@PathVariable UUID id, @RequestBody group updatedGroup) {
        if (!id.equals(updatedGroup.getGroup_id())) {
            throw new IllegalArgumentException("Group id in path variable does not match the id in the request body.");
        }

        return groupService.updateGroup(updatedGroup);
    }




}
