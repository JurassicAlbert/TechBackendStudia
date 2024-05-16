package com.capgemini.wsb.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * The PatientTO class is a Data Transfer Object (DTO) that represents a patient.
 * It includes information such as the patient's ID, name, contact details, date of birth, insurance status,
 * associated addresses, and visits.
 */
public class PatientTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private String email;
    private String patientNumber;
    private LocalDate dateOfBirth;
    private boolean hasInsurance;
    private List<AddressTO> addresses;
    private List<VisitTO> visits;

    /**
     * Gets the unique identifier of the patient.
     *
     * @return the ID of the patient
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the patient.
     *
     * @param id the new ID of the patient
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the first name of the patient.
     *
     * @return the first name of the patient
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the patient.
     *
     * @param firstName the new first name of the patient
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the patient.
     *
     * @return the last name of the patient
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the patient.
     *
     * @param lastName the new last name of the patient
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the telephone number of the patient.
     *
     * @return the telephone number of the patient
     */
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    /**
     * Sets the telephone number of the patient.
     *
     * @param telephoneNumber the new telephone number of the patient
     */
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    /**
     * Gets the email of the patient.
     *
     * @return the email of the patient
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the patient.
     *
     * @param email the new email of the patient
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the patient number of the patient.
     *
     * @return the patient number of the patient
     */
    public String getPatientNumber() {
        return patientNumber;
    }

    /**
     * Sets the patient number of the patient.
     *
     * @param patientNumber the new patient number of the patient
     */
    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    /**
     * Gets the date of birth of the patient.
     *
     * @return the date of birth of the patient
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the date of birth of the patient.
     *
     * @param dateOfBirth the new date of birth of the patient
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Checks if the patient has insurance.
     *
     * @return true if the patient has insurance, false otherwise
     */
    public boolean isHasInsurance() {
        return hasInsurance;
    }

    /**
     * Sets the insurance status of the patient.
     *
     * @param hasInsurance the new insurance status of the patient
     */
    public void setHasInsurance(boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }

    /**
     * Gets the list of addresses associated with the patient.
     *
     * @return the list of addresses
     */
    public List<AddressTO> getAddresses() {
        return addresses;
    }

    /**
     * Sets the list of addresses associated with the patient.
     *
     * @param addresses the new list of addresses
     */
    public void setAddresses(List<AddressTO> addresses) {
        this.addresses = addresses;
    }

    /**
     * Gets the list of visits associated with the patient.
     *
     * @return the list of visits
     */
    public List<VisitTO> getVisits() {
        return visits;
    }

    /**
     * Sets the list of visits associated with the patient.
     *
     * @param visits the new list of visits
     */
    public void setVisits(List<VisitTO> visits) {
        this.visits = visits;
    }
}