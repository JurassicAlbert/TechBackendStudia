package com.capgemini.wsb.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;

/**
 * VisitEntity is a JPA entity representing a visit.
 * It includes fields for description and time of the visit,
 * and has relationships with PatientEntity, DoctorEntity, and MedicalTreatmentEntity.
 */
@Entity
@Table(name = "VISIT")
public class VisitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "time")
    private LocalDateTime time;

    @ManyToOne
    @JoinColumn(name = "PATIENT_ID")
    @JsonBackReference
    private PatientEntity patient;

    @ManyToOne
    @JoinColumn(name = "DOCTOR_ID")
    @JsonBackReference
    private DoctorEntity doctor;

    @OneToMany(mappedBy = "visit", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<MedicalTreatmentEntity> medicalTreatments;

    /**
     * Gets the ID of the visit.
     *
     * @return the ID of the visit
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the visit.
     *
     * @param id the ID to set
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
     * @param description the description to set
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
     * @param time the time to set
     */
    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    /**
     * Gets the patient associated with the visit.
     *
     * @return the patient associated with the visit
     */
    public PatientEntity getPatient() {
        return patient;
    }

    /**
     * Sets the patient associated with the visit.
     *
     * @param patient the patient to set
     */
    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    /**
     * Gets the doctor associated with the visit.
     *
     * @return the doctor associated with the visit
     */
    public DoctorEntity getDoctor() {
        return doctor;
    }

    /**
     * Sets the doctor associated with the visit.
     *
     * @param doctor the doctor to set
     */
    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }

    /**
     * Gets the list of medical treatments associated with the visit.
     *
     * @return the list of medical treatments associated with the visit
     */
    public List<MedicalTreatmentEntity> getMedicalTreatments() {
        return medicalTreatments;
    }

    /**
     * Sets the list of medical treatments associated with the visit.
     *
     * @param medicalTreatments the list of medical treatments to set
     */
    public void setMedicalTreatments(List<MedicalTreatmentEntity> medicalTreatments) {
        this.medicalTreatments = medicalTreatments;
    }
}
