package com.capgemini.wsb.dto;

import com.capgemini.wsb.persistence.enums.Specialization;

import java.io.Serializable;
import java.util.List;

/**
 * The DoctorTO class is a Data Transfer Object (DTO) that represents a doctor.
 * It includes information such as first name, last name, contact details,
 * doctor number, specialization, and lists of associated addresses and visits.
 */
public class DoctorTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private String email;
    private String doctorNumber;
    private Specialization specialization;
    private List<AddressTO> addresses;
    private List<VisitTO> visits;

    /**
     * Gets the unique identifier of the doctor.
     *
     * @return the ID of the doctor
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the doctor.
     *
     * @param id the new ID of the doctor
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the first name of the doctor.
     *
     * @return the first name of the doctor
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the doctor.
     *
     * @param firstName the new first name of the doctor
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the doctor.
     *
     * @return the last name of the doctor
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the doctor.
     *
     * @param lastName the new last name of the doctor
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the telephone number of the doctor.
     *
     * @return the telephone number of the doctor
     */
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    /**
     * Sets the telephone number of the doctor.
     *
     * @param telephoneNumber the new telephone number of the doctor
     */
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    /**
     * Gets the email address of the doctor.
     *
     * @return the email address of the doctor
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the doctor.
     *
     * @param email the new email address of the doctor
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the unique doctor number.
     *
     * @return the doctor number
     */
    public String getDoctorNumber() {
        return doctorNumber;
    }

    /**
     * Sets the unique doctor number.
     *
     * @param doctorNumber the new doctor number
     */
    public void setDoctorNumber(String doctorNumber) {
        this.doctorNumber = doctorNumber;
    }

    /**
     * Gets the specialization of the doctor.
     *
     * @return the specialization of the doctor
     */
    public Specialization getSpecialization() {
        return specialization;
    }

    /**
     * Sets the specialization of the doctor.
     *
     * @param specialization the new specialization of the doctor
     */
    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    /**
     * Gets the list of addresses associated with the doctor.
     *
     * @return the list of addresses associated with the doctor
     */
    public List<AddressTO> getAddresses() {
        return addresses;
    }

    /**
     * Sets the list of addresses associated with the doctor.
     *
     * @param addresses the new list of addresses associated with the doctor
     */
    public void setAddresses(List<AddressTO> addresses) {
        this.addresses = addresses;
    }

    /**
     * Gets the list of visits associated with the doctor.
     *
     * @return the list of visits associated with the doctor
     */
    public List<VisitTO> getVisits() {
        return visits;
    }

    /**
     * Sets the list of visits associated with the doctor.
     *
     * @param visits the new list of visits associated with the doctor
     */
    public void setVisits(List<VisitTO> visits) {
        this.visits = visits;
    }
}
