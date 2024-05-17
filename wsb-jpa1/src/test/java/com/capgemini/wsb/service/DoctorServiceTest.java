//package com.capgemini.wsb.service;
//
//import com.capgemini.wsb.WsbJpaApplication;
//import com.capgemini.wsb.dto.DoctorTO;
//import com.capgemini.wsb.persistence.enums.Specialization;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest(classes = WsbJpaApplication.class)
//public class DoctorServiceTest {
//
//    @Autowired
//    private DoctorService doctorService;
//
//    @Test
//    public void testFindById() {
//        DoctorTO doctor = doctorService.findById(1L);
//        assertNotNull(doctor);
//        assertEquals("Tomasz", doctor.getFirstName());
//    }
//
//    @Test
//    public void testAddDoctor() {
//        DoctorTO doctorTO = new DoctorTO();
//        doctorTO.setFirstName("Jan");
//        doctorTO.setLastName("Kowalski");
//        doctorTO.setTelephoneNumber("123456789");
//        doctorTO.setEmail("jan.kowalski@example.com");
//        doctorTO.setDoctorNumber("D123");
//        doctorTO.setSpecialization(Specialization.GP);
//
//        DoctorTO createdDoctor = doctorService.addDoctor(doctorTO);
//        assertNotNull(createdDoctor);
//        assertNotNull(createdDoctor.getId());
//        assertEquals("Jan", createdDoctor.getFirstName());
//    }
//
//    @Test
//    public void testUpdateDoctor() {
//        DoctorTO doctorTO = doctorService.findById(1L);
//        assertNotNull(doctorTO);
//        doctorTO.setLastName("UpdatedLastName");
//
//        DoctorTO updatedDoctor = doctorService.updateDoctor(doctorTO);
//        assertNotNull(updatedDoctor);
//        assertEquals("UpdatedLastName", updatedDoctor.getLastName());
//    }
//
//    @Test
//    public void testRemoveDoctor() {
//        DoctorTO doctorTO = new DoctorTO();
//        doctorTO.setFirstName("ToRemove");
//        doctorTO.setLastName("Doctor");
//        doctorTO.setTelephoneNumber("987654321");
//        doctorTO.setEmail("toremove.doctor@example.com");
//        doctorTO.setDoctorNumber("R123");
//        doctorTO.setSpecialization(Specialization.SURGEON);
//
//        DoctorTO createdDoctor = doctorService.addDoctor(doctorTO);
//        Long id = createdDoctor.getId();
//        doctorService.removeDoctor(id);
//        assertNull(doctorService.findById(id));
//    }
//
//    @Test
//    public void testGetDoctorList() {
//        List<DoctorTO> doctors = doctorService.getDoctorList();
//        assertNotNull(doctors);
//        assertFalse(doctors.isEmpty());
//    }
//}
