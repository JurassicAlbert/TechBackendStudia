package com.capgemini.wsb.persistence.entity;

import com.capgemini.wsb.persistence.enums.TreatmentType;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 * MedicalTreatmentEntity is a JPA entity representing a medical treatment.
 * It includes fields for description and type of treatment,
 * and has a relationship with VisitEntity.
 */
@Entity
@Table(name = "MEDICAL_TREATMENT")
public class MedicalTreatmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private TreatmentType type;

    @ManyToOne
    @JoinColumn(name = "VISIT_ID")
    @JsonBackReference
    private VisitEntity visit;

    /**
     * Gets the ID of the medical treatment.
     *
     * @return the ID of the medical treatment
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the medical treatment.
     *
     * @param id the ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the description of the medical treatment.
     *
     * @return the description of the medical treatment
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the medical treatment.
     *
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the type of the medical treatment.
     *
     * @return the type of the medical treatment
     */
    public TreatmentType getType() {
        return type;
    }

    /**
     * Sets the type of the medical treatment.
     *
     * @param type the type to set
     */
    public void setType(TreatmentType type) {
        this.type = type;
    }

    /**
     * Gets the visit associated with the medical treatment.
     *
     * @return the visit associated with the medical treatment
     */
    public VisitEntity getVisit() {
        return visit;
    }

    /**
     * Sets the visit associated with the medical treatment.
     *
     * @param visit the visit to set
     */
    public void setVisit(VisitEntity visit) {
        this.visit = visit;
    }
}