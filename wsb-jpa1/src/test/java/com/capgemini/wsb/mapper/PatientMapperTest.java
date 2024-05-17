package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for PatientMapper.
 */
@SpringBootTest(classes = PatientMapperTest.class)
class PatientMapperTest {

    @Test
    void testMapToTO() {
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(1L);
        patientEntity.setFirstName("Alice");
        patientEntity.setLastName("Smith");
        patientEntity.setTelephoneNumber("987654321");
        patientEntity.setEmail("alice.smith@example.com");
        patientEntity.setPatientNumber("P123");
        patientEntity.setDateOfBirth(LocalDate.of(1990, 1, 1));
        patientEntity.setHasInsurance(true);

        PatientTO patientTO = PatientMapper.mapToTO(patientEntity);

        assertNotNull(patientTO);
        assertEquals(1L, patientTO.getId());
        assertEquals("Alice", patientTO.getFirstName());
        assertEquals("Smith", patientTO.getLastName());
        assertEquals("987654321", patientTO.getTelephoneNumber());
        assertEquals("alice.smith@example.com", patientTO.getEmail());
        assertEquals("P123", patientTO.getPatientNumber());
        assertEquals(LocalDate.of(1990, 1, 1), patientTO.getDateOfBirth());
        assertTrue(patientTO.isHasInsurance());
    }

    @Test
    void testMapToEntity() {
        PatientTO patientTO = new PatientTO();
        patientTO.setId(1L);
        patientTO.setFirstName("Alice");
        patientTO.setLastName("Smith");
        patientTO.setTelephoneNumber("987654321");
        patientTO.setEmail("alice.smith@example.com");
        patientTO.setPatientNumber("P123");
        patientTO.setDateOfBirth(LocalDate.of(1990, 1, 1));
        patientTO.setHasInsurance(true);

        PatientEntity patientEntity = PatientMapper.mapToEntity(patientTO);

        assertNotNull(patientEntity);
        assertEquals(1L, patientEntity.getId());
        assertEquals("Alice", patientEntity.getFirstName());
        assertEquals("Smith", patientEntity.getLastName());
        assertEquals("987654321", patientEntity.getTelephoneNumber());
        assertEquals("alice.smith@example.com", patientEntity.getEmail());
        assertEquals("P123", patientEntity.getPatientNumber());
        assertEquals(LocalDate.of(1990, 1, 1), patientEntity.getDateOfBirth());
        assertTrue(patientEntity.isHasInsurance());
    }
}
