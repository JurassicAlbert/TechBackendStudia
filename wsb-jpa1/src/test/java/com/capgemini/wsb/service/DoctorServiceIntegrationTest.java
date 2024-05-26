//package com.capgemini.wsb.service;
//
//import com.capgemini.wsb.dto.DoctorTO;
//import com.capgemini.wsb.persistence.dao.DoctorDao;
//import com.capgemini.wsb.persistence.dao.MedicalTreatmentDao;
//import com.capgemini.wsb.persistence.dao.VisitDao;
//import com.capgemini.wsb.persistence.entity.DoctorEntity;
//import com.capgemini.wsb.persistence.entity.VisitEntity;
//import com.capgemini.wsb.persistence.entity.MedicalTreatmentEntity;
//import com.capgemini.wsb.persistence.enums.Specialization;
//import com.capgemini.wsb.service.impl.DoctorServiceImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@Transactional
//public class DoctorServiceIntegrationTest {
//
//    @Autowired
//    private DoctorServiceImpl doctorService;
//
//    @Autowired
//    private DoctorDao doctorDao;
//
//    @Autowired
//    private VisitDao visitDao;
//
//    @Autowired
//    private MedicalTreatmentDao medicalTreatmentDao;
//
//    private Long savedDoctorId;
//
//    @BeforeEach
//    public void setup() {
//        medicalTreatmentDao.deleteAll();
//        visitDao.deleteAll();
//        doctorDao.deleteAll();
//
//        DoctorEntity doctorEntity = new DoctorEntity();
//        doctorEntity.setFirstName("Test");
//        doctorEntity.setLastName("Doctor");
//        doctorEntity.setTelephoneNumber("123456789");
//        doctorEntity.setEmail("test.unique.doctor@example.com"); // Ensure unique email
//        doctorEntity.setDoctorNumber("D999"); // Ensure unique doctor number
//        doctorEntity.setSpecialization(Specialization.GP);
//
//        VisitEntity visitEntity = new VisitEntity();
//        visitEntity.setDoctor(doctorEntity);
//
//        MedicalTreatmentEntity medicalTreatmentEntity = new MedicalTreatmentEntity();
//        medicalTreatmentEntity.setVisit(visitEntity);
//
//        visitEntity.setMedicalTreatments(new ArrayList<>());
//        visitEntity.getMedicalTreatments().add(medicalTreatmentEntity);
//
//        doctorEntity.setVisits(new ArrayList<>());
//        doctorEntity.getVisits().add(visitEntity);
//
//        doctorEntity = doctorDao.save(doctorEntity);
//        savedDoctorId = doctorEntity.getId();
//    }
//
//    /**
//     * Test finding a doctor by ID.
//     */
//    @Test
//    public void testFindById() {
//        DoctorTO doctor = doctorService.findById(savedDoctorId);
//        assertNotNull(doctor);
//        assertEquals("Test", doctor.getFirstName());
//    }
//
//    /**
//     * Test adding a new doctor.
//     */
//    @Test
//    public void testAddDoctor() {
//        DoctorTO doctorTO = new DoctorTO();
//        doctorTO.setFirstName("New");
//        doctorTO.setLastName("Doctor");
//        doctorTO.setTelephoneNumber("987654321");
//        doctorTO.setEmail("new.unique.doctor@example.com"); // Ensure unique email
//        doctorTO.setDoctorNumber("D124");
//        doctorTO.setSpecialization(Specialization.SURGEON);
//        DoctorTO savedDoctor = doctorService.addDoctor(doctorTO);
//        assertNotNull(savedDoctor.getId());
//        assertEquals("New", savedDoctor.getFirstName());
//    }
//
//    /**
//     * Test updating an existing doctor.
//     */
//    @Test
//    public void testUpdateDoctor() {
//        DoctorTO doctorTO = new DoctorTO();
//        doctorTO.setId(savedDoctorId);
//        doctorTO.setFirstName("Updated");
//        doctorTO.setLastName("Doctor");
//        doctorTO.setTelephoneNumber("123456789");
//        doctorTO.setEmail("updated.doctor@example.com"); // Ensure unique email
//        doctorTO.setDoctorNumber("D123");
//        doctorTO.setSpecialization(Specialization.GP);
//        DoctorTO updatedDoctor = doctorService.updateDoctor(doctorTO);
//        assertEquals("Updated", updatedDoctor.getFirstName());
//    }
//
//    /**
//     * Test removing a doctor by ID.
//     */
//    @Test
//    public void testRemoveDoctor() {
//        doctorService.removeDoctor(savedDoctorId);
//        DoctorEntity deletedDoctor = doctorDao.findById(savedDoctorId).orElse(null);
//        assertNull(deletedDoctor);
//    }
//
//    /**
//     * Test getting the list of all doctors.
//     */
//    @Test
//    public void testGetDoctorList() {
//        DoctorTO doctorTO = new DoctorTO();
//        doctorTO.setFirstName("Another");
//        doctorTO.setLastName("Doctor");
//        doctorTO.setTelephoneNumber("987654321");
//        doctorTO.setEmail("another.unique.doctor@example.com"); // Ensure unique email
//        doctorTO.setDoctorNumber("D125");
//        doctorTO.setSpecialization(Specialization.DERMATOLOGIST);
//        doctorService.addDoctor(doctorTO);
//
//        assertEquals(2, doctorService.getDoctorList().size());
//    }
//
//    /**
//     * Test getting the total number of doctors.
//     */
//    @Test
//    public void testDoctorsNumber() {
//        assertEquals(1, doctorService.DoctorsNumber());
//    }
//}
