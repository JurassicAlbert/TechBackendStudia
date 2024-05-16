package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.MedicalTreatmentTO;

import java.util.List;

/**
 * Service interface for managing medical treatments.
 */
public interface MedicalTreatmentService {

    /**
     * Finds a medical treatment by its ID.
     *
     * @param id the ID of the medical treatment to find
     * @return the found medical treatment
     */
    MedicalTreatmentTO findById(Long id);

    /**
     * Adds a new medical treatment.
     *
     * @param medicalTreatmentTO the medical treatment data transfer object
     * @return the added medical treatment
     */
    MedicalTreatmentTO addMedicalTreatment(MedicalTreatmentTO medicalTreatmentTO);

    /**
     * Updates an existing medical treatment.
     *
     * @param medicalTreatmentTO the updated medical treatment data transfer object
     * @return the updated medical treatment
     */
    MedicalTreatmentTO updateMedicalTreatment(MedicalTreatmentTO medicalTreatmentTO);

    /**
     * Deletes a medical treatment by its ID.
     *
     * @param id the ID of the medical treatment to delete
     */
    void removeMedicalTreatment(Long id);

    /**
     * Gets the list of all medical treatments.
     *
     * @return the list of all medical treatments
     */
    List<MedicalTreatmentTO> getMedicalTreatmentList();
}