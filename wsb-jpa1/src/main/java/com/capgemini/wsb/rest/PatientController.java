package com.capgemini.wsb.controller;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * PatientController is a REST controller for managing patients.
 * It provides endpoints for CRUD operations and retrieving patient-related data.
 */
@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    /**
     * Get a patient by ID.
     *
     * @param id the ID of the patient
     * @return the patient with the specified ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<PatientTO> getPatientById(@PathVariable Long id) {
        PatientTO patient = patientService.findById(id);
        return ResponseEntity.ok(patient);
    }

    /**
     * Add a new patient.
     *
     * @param patientTO the patient data transfer object
     * @return the added patient
     */
    @PostMapping
    public ResponseEntity<PatientTO> addPatient(@RequestBody PatientTO patientTO) {
        PatientTO createdPatient = patientService.addPatient(patientTO);
        return ResponseEntity.ok(createdPatient);
    }

    /**
     * Update an existing patient.
     *
     * @param id the ID of the patient to update
     * @param patientTO the updated patient data transfer object
     * @return the updated patient
     */
    @PutMapping("/{id}")
    public ResponseEntity<PatientTO> updatePatient(@PathVariable Long id, @RequestBody PatientTO patientTO) {
        patientTO.setId(id);
        PatientTO updatedPatient = patientService.updatePatient(patientTO);
        return ResponseEntity.ok(updatedPatient);
    }

    /**
     * Delete a patient by ID.
     *
     * @param id the ID of the patient to delete
     * @return ResponseEntity with no content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.removePatient(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Get all visits for a specific patient.
     *
     * @param patientId the ID of the patient
     * @return the list of visits for the patient
     */
    @GetMapping("/{patientId}/visits")
    public ResponseEntity<List<VisitTO>> getAllVisitsForPatient(@PathVariable Long patientId) {
        List<VisitTO> visits = patientService.getAllVisitsForPatient(patientId);
        return ResponseEntity.ok(visits);
    }

    /**
     * Get a patient with their visits.
     *
     * @param patientId the ID of the patient
     * @return the patient with their visits
     */
    @GetMapping("/{patientId}/with-visits")
    public ResponseEntity<PatientTO> getPatientWithVisits(@PathVariable Long patientId) {
        PatientTO patientWithVisits = patientService.getPatientWithVisits(patientId);
        return ResponseEntity.ok(patientWithVisits);
    }

    /**
     * Get the list of all patients.
     *
     * @return the list of all patients
     */
    @GetMapping
    public ResponseEntity<List<PatientTO>> getPatientList() {
        List<PatientTO> patients = patientService.getPatientList();
        return ResponseEntity.ok(patients);
    }
}