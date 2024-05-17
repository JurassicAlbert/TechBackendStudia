//package com.capgemini.wsb.service;
//
//import com.capgemini.wsb.WsbJpaApplication;
//import com.capgemini.wsb.dto.PatientTO;
//import com.capgemini.wsb.dto.VisitTO;
//import com.capgemini.wsb.dto.DoctorTO;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest(classes = WsbJpaApplication.class)
//public class PatientServiceTest {
//
//    @Autowired
//    private PatientService patientService;
//
//    @Autowired
//    private DoctorService doctorService;
//
//    @Autowired
//    private VisitService visitService;
//
//    @Test
//    public void testFindById() {
//        PatientTO patient = patientService.findById(1L);
//        assertNotNull(patient);
//        assertEquals("Piotr", patient.getFirstName());
//    }
//
//    @Test
//    public void testAddPatient() {
//        PatientTO patientTO = new PatientTO();
//        patientTO.setFirstName("Anna");
//        patientTO.setLastName("Kowalska");
//        patientTO.setTelephoneNumber("123456789");
//        patientTO.setEmail("anna.kowalska@example.com");
//        patientTO.setPatientNumber("P123");
//        patientTO.setDateOfBirth(LocalDate.of(1980, 1, 1));
//        patientTO.setHasInsurance(true);
//
//        PatientTO createdPatient = patientService.addPatient(patientTO);
//        assertNotNull(createdPatient);
//        assertNotNull(createdPatient.getId());
//        assertEquals("Anna", createdPatient.getFirstName());
//    }
//
//    @Test
//    public void testUpdatePatient() {
//        PatientTO patientTO = patientService.findById(1L);
//        assertNotNull(patientTO);
//        patientTO.setLastName("UpdatedLastName");
//
//        PatientTO updatedPatient = patientService.updatePatient(patientTO);
//        assertNotNull(updatedPatient);
//        assertEquals("UpdatedLastName", updatedPatient.getLastName());
//    }
//
//    @Test
//    public void testRemovePatient() {
//        PatientTO patientTO = new PatientTO();
//        patientTO.setFirstName("ToRemove");
//        patientTO.setLastName("Patient");
//        patientTO.setTelephoneNumber("987654321");
//        patientTO.setEmail("toremove.patient@example.com");
//        patientTO.setPatientNumber("P123");
//        patientTO.setDateOfBirth(LocalDate.of(1990, 1, 1));
//        patientTO.setHasInsurance(false);
//
//        PatientTO createdPatient = patientService.addPatient(patientTO);
//        Long id = createdPatient.getId();
//
//        // Adding a visit to ensure the patient has associated visits
//        VisitTO visitTO = new VisitTO();
//        visitTO.setDescription("Initial Visit");
//        visitTO.setTime(LocalDateTime.now());
//        visitTO.setPatient(createdPatient);
//        visitTO.setDoctor(doctorService.findById(1L));  // Assuming there's a doctor with ID 1
//        visitService.addVisit(visitTO);
//
//        List<VisitTO> visitsBeforeDelete = patientService.getAllVisitsForPatient(id);
//        assertNotNull(visitsBeforeDelete);
//        assertFalse(visitsBeforeDelete.isEmpty());
//
//        patientService.removePatient(id);
//        assertNull(patientService.findById(id));
//
//        // Ensure cascade delete works
//        List<VisitTO> visits = patientService.getAllVisitsForPatient(id);
//        assertTrue(visits == null || visits.isEmpty());
//
//        // Ensure doctors are not deleted
//        List<DoctorTO> doctors = doctorService.getDoctorList();
//        assertFalse(doctors.isEmpty());
//    }
//
//    @Test
//    public void testGetAllVisitsForPatient() {
//        List<VisitTO> visits = patientService.getAllVisitsForPatient(1L);
//        assertNotNull(visits);
//        assertFalse(visits.isEmpty());
//    }
//
//    @Test
//    public void testGetPatientWithVisits() {
//        PatientTO patient = patientService.getPatientWithVisits(1L);
//        assertNotNull(patient);
//        assertNotNull(patient.getVisits());
//        assertFalse(patient.getVisits().isEmpty());
//    }
//
//    @Test
//    public void testGetPatientList() {
//        List<PatientTO> patients = patientService.getPatientList();
//        assertNotNull(patients);
//        assertFalse(patients.isEmpty());
//    }
//}
