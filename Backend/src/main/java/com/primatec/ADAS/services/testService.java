package com.primatec.ADAS.services;
import com.primatec.ADAS.DAO.testDAO;
import com.primatec.ADAS.model.project;
import com.primatec.ADAS.model.test.test;
import com.primatec.ADAS.model.user;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

    public class testService {
    private final testDAO testDAO;
    private final projectServices projectServices;

    @Autowired
    public testService(testDAO testDAO,projectServices projectServices) {
        this.testDAO = testDAO;
        this.projectServices=projectServices;
    }

    public test addTest(test test, project project) {
        test.setProject(project);
        return testDAO.save(test);
    }
    public test assignUser(test test, user user){
        test.setTester(user);
        return testDAO.save(test);
    }

    public test updateTest(test updatedTest) {
        // Check if the test exists in the database
        Optional<test> optionalTest = testDAO.findById(updatedTest.getTestId());
        if (optionalTest.isPresent()) {
            test existingTest = optionalTest.get();
            existingTest.setTestName(updatedTest.getTestName());
            existingTest.setTestDate(updatedTest.getTestDate());
            existingTest.setTestResult(updatedTest.getTestResult());
            existingTest.setTestpriority(updatedTest.getTestpriority());
            existingTest.setDomain(updatedTest.getDomain());
            // Update other test attributes as needed

            return testDAO.save(existingTest);
        } else {
            // Test not found, throw an exception or handle the error accordingly
            throw new EntityNotFoundException("Test with id " + updatedTest.getTestId() + " not found.");
        }
    }

    public void deleteTest(UUID testId) {
        testDAO.deleteById(testId);
    }

    public List<test> getAllTestsByProject(project project) {
        return testDAO.findByProject(project.getProjectId());
    }
    public Optional<test> getTestById(UUID id) {
        return testDAO.findById(id);
    }



    public List<Map<String, Object>> getNumberOfTestsPerMonthPerUserDomain(UUID userId) {
        List<Map<String, Object>> result = testDAO.findNumberOfTestsPerMonthPerUserDomain(userId);

        // Format the result as needed
        List<Map<String, Object>> formattedResult = new ArrayList<>();
        for (Map<String, Object> row : result) {
            Map<String, Object> formattedRow = new HashMap<>();
            formattedRow.put("userId", row.get("userId"));
            formattedRow.put("test", List.of(
                    Map.of("month", row.get("month"), "year", row.get("year"),"domain", row.get("domain"), "number", row.get("numberOfTests"))
            ));
            formattedResult.add(formattedRow);
        }

        return formattedResult;
    }
}


