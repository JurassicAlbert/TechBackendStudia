//package com.capgemini.wsb.service;
//
//import com.capgemini.wsb.WsbJpaApplication;
//import com.capgemini.wsb.dto.MedicalTreatmentTO;
//import com.capgemini.wsb.persistence.enums.TreatmentType;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest(classes = WsbJpaApplication.class)
//public class MedicalTreatmentServiceTest {
//
//    @Autowired
//    private MedicalTreatmentService medicalTreatmentService;
//
//    @Test
//    public void testFindById() {
//        MedicalTreatmentTO treatment = medicalTreatmentService.findById(1L);
//        assertNotNull(treatment);
//        assertEquals("Szczepienie przeciw grypie", treatment.getDescription());
//    }
//
//    @Test
//    public void testAddMedicalTreatment() {
//        MedicalTreatmentTO treatmentTO = new MedicalTreatmentTO();
//        treatmentTO.setDescription("New Treatment");
//        treatmentTO.setType(TreatmentType.USG);
//
//        MedicalTreatmentTO createdTreatment = medicalTreatmentService.addMedicalTreatment(treatmentTO);
//        assertNotNull(createdTreatment);
//        assertNotNull(createdTreatment.getId());
//        assertEquals("New Treatment", createdTreatment.getDescription());
//    }
//
//    @Test
//    public void testUpdateMedicalTreatment() {
//        MedicalTreatmentTO treatmentTO = medicalTreatmentService.findById(1L);
//        assertNotNull(treatmentTO);
//        treatmentTO.setDescription("Updated Treatment");
//
//        MedicalTreatmentTO updatedTreatment = medicalTreatmentService.updateMedicalTreatment(treatmentTO);
//        assertNotNull(updatedTreatment);
//        assertEquals("Updated Treatment", updatedTreatment.getDescription());
//    }
//
//    @Test
//    public void testRemoveMedicalTreatment() {
//        MedicalTreatmentTO treatmentTO = new MedicalTreatmentTO();
//        treatmentTO.setDescription("ToRemove Treatment");
//        treatmentTO.setType(TreatmentType.EKG);
//
//        MedicalTreatmentTO createdTreatment = medicalTreatmentService.addMedicalTreatment(treatmentTO);
//        Long id = createdTreatment.getId();
//        medicalTreatmentService.removeMedicalTreatment(id);
//        assertNull(medicalTreatmentService.findById(id));
//    }
//
//    @Test
//    public void testGetMedicalTreatmentList() {
//        List<MedicalTreatmentTO> treatments = medicalTreatmentService.getMedicalTreatmentList();
//        assertNotNull(treatments);
//        assertFalse(treatments.isEmpty());
//    }
//}
