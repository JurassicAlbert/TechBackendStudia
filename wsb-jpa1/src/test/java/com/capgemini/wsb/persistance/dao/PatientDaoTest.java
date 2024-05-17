package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

/**
 * Unit tests for the PatientDao interface.
 */
@SpringBootTest
@Transactional
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    /**
     * Test for finding patients with more visits than a specified number.
     */
    @Transactional
    @Test
    public void testFindAllPatientsWithMoreVisitsThan() {
        // given
        int minNumberOfVisits = 2;

        // when
        List<PatientEntity> listOfVisits = patientDao.findAllPatientsWithMoreVisitsThan(minNumberOfVisits);

        // then
        Assertions.assertNotNull(listOfVisits);
        Assertions.assertTrue(listOfVisits.stream().allMatch(patient -> patient.getVisits().size() > minNumberOfVisits));
    }

    /**
     * Test for finding patients older than a specified age.
     */
    @Transactional
    @Test
    public void testFindAllPatientsOlderThan() {
        // given
        int age = 30;

        // when
        List<PatientEntity> listOfPatients = patientDao.findPatientsOlderThan(age);

        // then
        Assertions.assertNotNull(listOfPatients);
        Assertions.assertTrue(listOfPatients.stream().allMatch(patient -> {
            LocalDate currentDate = LocalDate.now();
            LocalDate birthDateThreshold = currentDate.minusYears(age);
            return patient.getDateOfBirth().isBefore(birthDateThreshold);
        }));
    }

    /**
     * Test for finding patients younger than a specified age.
     */
    @Transactional
    @Test
    public void testFindAllPatientsYoungerThan() {
        // given
        int age = 30;

        // when
        List<PatientEntity> listOfPatients = patientDao.findPatientsYoungerThan(age);

        // then
        Assertions.assertNotNull(listOfPatients);
        Assertions.assertTrue(listOfPatients.stream().allMatch(patient -> {
            LocalDate currentDate = LocalDate.now();
            LocalDate birthDateThreshold = currentDate.minusYears(age);
            return patient.getDateOfBirth().isAfter(birthDateThreshold);
        }));
    }

    /**
     * Test for finding patients by their last name.
     */
    @Transactional
    @Test
    public void testFindPatientByLastName() {
        // given
        PatientEntity patientEntity1 = new PatientEntity();
        patientEntity1.setFirstName("John");
        patientEntity1.setLastName("Doe");
        patientEntity1.setTelephoneNumber("1234567890");
        patientEntity1.setEmail("john.doe@gmail.com");
        patientEntity1.setPatientNumber("P001");
        patientEntity1.setDateOfBirth(LocalDate.of(1985, 5, 15));
        patientEntity1.setHasInsurance(true);

        PatientEntity patientEntity2 = new PatientEntity();
        patientEntity2.setFirstName("Jane");
        patientEntity2.setLastName("Doe");
        patientEntity2.setTelephoneNumber("0987654321");
        patientEntity2.setEmail("jane.doe@gmail.com");
        patientEntity2.setPatientNumber("P002");
        patientEntity2.setDateOfBirth(LocalDate.of(1992, 8, 20));
        patientEntity2.setHasInsurance(false);

        int patientListInitSize = patientDao.findAll().size();
        int patientListSizeStartsOnLastName = patientDao.findByLastName("Doe").size();

        // when
        patientDao.save(patientEntity1);
        patientDao.save(patientEntity2);
        Collection<Object> patients = patientDao.findByLastName("Doe");

        // then
        Assertions.assertEquals(patientListInitSize + 2, patientDao.findAll().size());
        Assertions.assertEquals(patientListSizeStartsOnLastName + 2, patients.size());
    }

}
