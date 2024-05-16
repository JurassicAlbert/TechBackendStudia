package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;

import java.util.List;

/**
 * Service interface for managing patients.
 */
public interface PatientService {

    /**
     * Finds a patient by their ID.
     *
     * @param id the ID of the patient to find
     * @return the found patient
     */
    PatientTO findById(Long id);

    /**
     * Adds a new patient.
     *
     * @param patientTO the patient data transfer object
     * @return the added patient
     */
    PatientTO addPatient(PatientTO patientTO);

    /**
     * Updates an existing patient.
     *
     * @param patientTO the updated patient data transfer object
     * @return the updated patient
     */
    PatientTO updatePatient(PatientTO patientTO);

    /**
     * Deletes a patient by their ID.
     *
     * @param id the ID of the patient to delete
     */
    void removePatient(Long id);

    /**
     * Gets all visits for a specific patient.
     *
     * @param patientId the ID of the patient
     * @return the list of visits for the patient
     */
    List<VisitTO> getAllVisitsForPatient(Long patientId);

    /**
     * Gets a patient with their visits.
     *
     * @param patientId the ID of the patient
     * @return the patient with their visits
     */
    PatientTO getPatientWithVisits(Long patientId);

    /**
     * Gets the list of all patients.
     *
     * @return the list of all patients
     */
    List<PatientTO> getPatientList();
}
