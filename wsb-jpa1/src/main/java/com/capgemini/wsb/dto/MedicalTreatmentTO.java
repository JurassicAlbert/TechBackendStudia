package com.capgemini.wsb.dto;

import com.capgemini.wsb.persistence.enums.TreatmentType;

import java.io.Serializable;

/**
 * The MedicalTreatmentTO class is a Data Transfer Object (DTO) that represents a medical treatment.
 * It includes information such as the treatment ID, description, and type.
 */
public class MedicalTreatmentTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String description;
    private TreatmentType type;

    /**
     * Gets the unique identifier of the medical treatment.
     *
     * @return the ID of the medical treatment
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the medical treatment.
     *
     * @param id the new ID of the medical treatment
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
     * @param description the new description of the medical treatment
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
     * @param type the new type of the medical treatment
     */
    public void setType(TreatmentType type) {
        this.type = type;
    }
}