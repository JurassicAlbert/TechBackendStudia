//package com.capgemini.wsb.service;
//
//import com.capgemini.wsb.WsbJpaApplication;
//import com.capgemini.wsb.dto.VisitTO;
//import com.capgemini.wsb.dto.PatientTO;
//import com.capgemini.wsb.dto.DoctorTO;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest(classes = WsbJpaApplication.class)
//public class VisitServiceTest {
//
//    @Autowired
//    private VisitService visitService;
//
//    @Autowired
//    private PatientService patientService;
//
//    @Autowired
//    private DoctorService doctorService;
//
//    @Test
//    public void testFindById() {
//        VisitTO visit = visitService.findById(1L);
//        assertNotNull(visit);
//        assertEquals("Badanie kontrolne", visit.getDescription());
//    }
//
//    @Test
//    public void testAddVisit() {
//        VisitTO visitTO = new VisitTO();
//        visitTO.setDescription("New Visit");
//        visitTO.setTime(LocalDateTime.now());
//
//        // Assuming there are existing Patient and Doctor with IDs 1 and 1
//        PatientTO patient = patientService.findById(1L);
//        DoctorTO doctor = doctorService.findById(1L);
//        assertNotNull(patient);
//        assertNotNull(doctor);
//        visitTO.setPatient(patient);
//        visitTO.setDoctor(doctor);
//
//        VisitTO createdVisit = visitService.addVisit(visitTO);
//        assertNotNull(createdVisit);
//        assertNotNull(createdVisit.getId());
//        assertEquals("New Visit", createdVisit.getDescription());
//    }
//
//    @Test
//    public void testUpdateVisit() {
//        VisitTO visitTO = visitService.findById(1L);
//        assertNotNull(visitTO);
//        visitTO.setDescription("Updated Visit");
//
//        VisitTO updatedVisit = visitService.updateVisit(visitTO);
//        assertNotNull(updatedVisit);
//        assertEquals("Updated Visit", updatedVisit.getDescription());
//    }
//
//    @Test
//    public void testRemoveVisit() {
//        VisitTO visitTO = new VisitTO();
//        visitTO.setDescription("ToRemove Visit");
//        visitTO.setTime(LocalDateTime.now());
//
//        // Assuming there are existing Patient and Doctor with IDs 1 and 1
//        PatientTO patient = patientService.findById(1L);
//        DoctorTO doctor = doctorService.findById(1L);
//        assertNotNull(patient);
//        assertNotNull(doctor);
//        visitTO.setPatient(patient);
//        visitTO.setDoctor(doctor);
//
//        VisitTO createdVisit = visitService.addVisit(visitTO);
//        Long id = createdVisit.getId();
//        visitService.removeVisit(id);
//        assertNull(visitService.findById(id));
//    }
//
//    @Test
//    public void testFindAllVisits() {
//        List<VisitTO> visits = visitService.findAllVisits();
//        assertNotNull(visits);
//        assertFalse(visits.isEmpty());
//    }
//}
