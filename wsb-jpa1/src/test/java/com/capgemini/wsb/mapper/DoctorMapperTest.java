package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.enums.Specialization;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for DoctorMapper.
 */
@SpringBootTest(classes = DoctorMapperTest.class)
class DoctorMapperTest {

    @Test
    void testMapToTO() {
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setId(1L);
        doctorEntity.setFirstName("John");
        doctorEntity.setLastName("Doe");
        doctorEntity.setTelephoneNumber("123456789");
        doctorEntity.setEmail("john.doe@example.com");
        doctorEntity.setDoctorNumber("D123");
        doctorEntity.setSpecialization(Specialization.GP);

        DoctorTO doctorTO = DoctorMapper.mapToTO(doctorEntity);

        assertNotNull(doctorTO);
        assertEquals(1L, doctorTO.getId());
        assertEquals("John", doctorTO.getFirstName());
        assertEquals("Doe", doctorTO.getLastName());
        assertEquals("123456789", doctorTO.getTelephoneNumber());
        assertEquals("john.doe@example.com", doctorTO.getEmail());
        assertEquals("D123", doctorTO.getDoctorNumber());
        assertEquals(Specialization.GP, doctorTO.getSpecialization());
    }

    @Test
    void testMapToEntity() {
        DoctorTO doctorTO = new DoctorTO();
        doctorTO.setId(1L);
        doctorTO.setFirstName("John");
        doctorTO.setLastName("Doe");
        doctorTO.setTelephoneNumber("123456789");
        doctorTO.setEmail("john.doe@example.com");
        doctorTO.setDoctorNumber("D123");
        doctorTO.setSpecialization(Specialization.GP);

        DoctorEntity doctorEntity = DoctorMapper.mapToEntity(doctorTO);

        assertNotNull(doctorEntity);
        assertEquals(1L, doctorEntity.getId());
        assertEquals("John", doctorEntity.getFirstName());
        assertEquals("Doe", doctorEntity.getLastName());
        assertEquals("123456789", doctorEntity.getTelephoneNumber());
        assertEquals("john.doe@example.com", doctorEntity.getEmail());
        assertEquals("D123", doctorEntity.getDoctorNumber());
        assertEquals(Specialization.GP, doctorEntity.getSpecialization());
    }
}
