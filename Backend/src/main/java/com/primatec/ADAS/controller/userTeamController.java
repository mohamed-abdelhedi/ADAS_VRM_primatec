package com.primatec.ADAS.controller;
import com.primatec.ADAS.services.userTeamServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;
import java.util.UUID;
@RestController
@RequestMapping("/api/teams")
public class userTeamController {
    private userTeamServices userTeamServices;
    @Autowired
    public void userTeamController(userTeamServices userTeamServices) {
        this.userTeamServices = userTeamServices;}

    @PutMapping("/{teamId}/assign-resources-users-and-projects")
    public void assignResourcesUsersAndProjectsToTeam(
            @PathVariable UUID teamId,
            @RequestBody Map<String, Set<UUID>> request) {

        Set<UUID> resourceIds = request.get("resourceIds");
        Set<UUID> userIds = request.get("userIds");
        Set<UUID> projectIds = request.get("projectIds");

        userTeamServices.assignResourcesUsersAndProjectsToTeam(teamId, resourceIds, userIds, projectIds);
    }

}

