package com.capgemini.wsb.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * The VisitTO class is a Data Transfer Object (DTO) that represents a medical visit.
 * It includes information such as the visit ID, description, time, patient, doctor,
 * and a list of associated medical treatments.
 */
public class VisitTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String description;
    private LocalDateTime time;
    private PatientTO patient;
    private DoctorTO doctor;
    private List<MedicalTreatmentTO> medicalTreatments;

    /**
     * Gets the unique identifier of the visit.
     *
     * @return the ID of the visit
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the visit.
     *
     * @param id the new ID of the visit
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the description of the visit.
     *
     * @return the description of the visit
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the visit.
     *
     * @param description the new description of the visit
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the time of the visit.
     *
     * @return the time of the visit
     */
    public LocalDateTime getTime() {
        return time;
    }

    /**
     * Sets the time of the visit.
     *
     * @param time the new time of the visit
     */
    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    /**
     * Gets the patient associated with the visit.
     *
     * @return the patient of the visit
     */
    public PatientTO getPatient() {
        return patient;
    }

    /**
     * Sets the patient associated with the visit.
     *
     * @param patient the new patient of the visit
     */
    public void setPatient(PatientTO patient) {
        this.patient = patient;
    }

    /**
     * Gets the doctor associated with the visit.
     *
     * @return the doctor of the visit
     */
    public DoctorTO getDoctor() {
        return doctor;
    }

    /**
     * Sets the doctor associated with the visit.
     *
     * @param doctor the new doctor of the visit
     */
    public void setDoctor(DoctorTO doctor) {
        this.doctor = doctor;
    }

    /**
     * Gets the list of medical treatments associated with the visit.
     *
     * @return the list of medical treatments
     */
    public List<MedicalTreatmentTO> getMedicalTreatments() {
        return medicalTreatments;
    }

    /**
     * Sets the list of medical treatments associated with the visit.
     *
     * @param medicalTreatments the new list of medical treatments
     */
    public void setMedicalTreatments(List<MedicalTreatmentTO> medicalTreatments) {
        this.medicalTreatments = medicalTreatments;
    }
}