package com.primatec.ADAS.services;
import com.primatec.ADAS.DAO.testDAO;
import com.primatec.ADAS.model.project;
import com.primatec.ADAS.model.test.test;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

        public test updateTest(test updatedTest) {
            // Check if the test exists in the database
            Optional<test> optionalTest = testDAO.findById(updatedTest.getTestId());
            if (optionalTest.isPresent()) {
                test existingTest = optionalTest.get();
                existingTest.setTestName(updatedTest.getTestName());
                existingTest.setTestDate(updatedTest.getTestDate());
                existingTest.setTestResult(updatedTest.getTestResult());
                existingTest.setTestpriority(updatedTest.getTestpriority());
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

        public List<test> getAllTestsByProject(Optional<Optional<project>> project) {
            return testDAO.findByProject(project);
        }
         public Optional<test> getTestById(UUID id) {
        return testDAO.findById(id);
    }
}


