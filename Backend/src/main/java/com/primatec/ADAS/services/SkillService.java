package com.primatec.ADAS.services;

import com.primatec.ADAS.DAO.UserSkillDAO;
import com.primatec.ADAS.DAO.skillDAO;
import com.primatec.ADAS.DAO.usersDAO;


import com.primatec.ADAS.DTO.UserSkillRequest;
import com.primatec.ADAS.model.skill;
import com.primatec.ADAS.model.UserSkill;
import com.primatec.ADAS.model.User.User;
import com.primatec.ADAS.model.workload.Workload;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SkillService {

    private final skillDAO skillDAO;
    private final UserSkillDAO UserSkillDAO;
    private final usersDAO usersDAO;


    @Autowired
    public SkillService(skillDAO skillDAO,usersDAO usersDAO,UserSkillDAO UserSkillDAO) {
        this.skillDAO = skillDAO;
        this.usersDAO = usersDAO;
        this.UserSkillDAO = UserSkillDAO;

    }

    public void saveSkill(skill skill) {
        skillDAO.save(skill);
    }

    public List<skill> getAllSkills() {
        return skillDAO.findAll();
    }

    public Optional<skill> getSkillById(UUID id) {
        return skillDAO.findById(id);
    }

    public void deleteSkill(UUID id) {
        skillDAO.deleteById(id);
    }

    public void addUserSkills(UUID userId, List<UserSkillRequest> userSkillRequests) {
        Optional<User> optionalUser = usersDAO.findById(userId);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            for (UserSkillRequest request : userSkillRequests) {
                Optional<skill> optionalSkill = skillDAO.findById(request.getSkillId());

                if (optionalSkill.isPresent()) {
                    skill skill = optionalSkill.get();
                    LocalDate currentDate = YearMonth.now().atDay(1);
                    UserSkill userSkill = new UserSkill(user, skill,currentDate, request.getProficiency());
                    UserSkillDAO.save(userSkill);
                } else {
                    throw new EntityNotFoundException("Skill not found with ID: " + request.getSkillId());
                }
            }
        } else {
            throw new EntityNotFoundException("User not found with ID: " + userId);
        }
    }


    public List<Object[]> getUserSkillGraph(UUID userId, UUID skillId) {
        return UserSkillDAO.getUserSkillGraph(userId, skillId);
    }
    public List<Object[]> getUserSkillproficiency(UUID userId, UUID skillId) {
        return UserSkillDAO.getUserSkillproficiency(userId, skillId);
    }

    public Optional<skill> getUserById(UUID skillId) {return skillDAO.findById(skillId);
    }
    public List<Object> getUserSkillsWithSkillNameAndProficiency(UUID userId) {
        return UserSkillDAO.findUserSkillsWithSkillNameAndProficiency(userId);
    }

    public UserSkill updateUserSkill(UserSkill updatedUserSkill) {
        Optional<UserSkill> optionalUserSkill = UserSkillDAO.findById(updatedUserSkill.getUser_skill_id());
        if (optionalUserSkill.isPresent()) {
            UserSkill existingUserSkill = optionalUserSkill.get();
            existingUserSkill.setUser(existingUserSkill.getUser());
            existingUserSkill.setProficiency(updatedUserSkill.getProficiency());

            return UserSkillDAO.save(existingUserSkill);
        } else {
            throw new EntityNotFoundException("updateUserSkill with id " + updatedUserSkill.getUser_skill_id() + " not found.");
        }
    }
}
