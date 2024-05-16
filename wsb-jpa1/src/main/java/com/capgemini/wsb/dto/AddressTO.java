package com.capgemini.wsb.dto;

import java.io.Serializable;
import java.util.List;

/**
 * The AddressTO class is a Data Transfer Object (DTO) that represents an address.
 * It includes information such as city, address lines, postal code, and lists of associated doctors and patients.
 */
public class AddressTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String city;
    private String addressLine1;
    private String addressLine2;
    private String postalCode;
    private List<DoctorTO> doctors;
    private List<PatientTO> patients;

    /**
     * Gets the unique identifier of the address.
     *
     * @return the ID of the address
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the address.
     *
     * @param id the new ID of the address
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the city of the address.
     *
     * @return the city of the address
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city of the address.
     *
     * @param city the new city of the address
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the first line of the address.
     *
     * @return the first line of the address
     */
    public String getAddressLine1() {
        return addressLine1;
    }

    /**
     * Sets the first line of the address.
     *
     * @param addressLine1 the new first line of the address
     */
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    /**
     * Gets the second line of the address.
     *
     * @return the second line of the address
     */
    public String getAddressLine2() {
        return addressLine2;
    }

    /**
     * Sets the second line of the address.
     *
     * @param addressLine2 the new second line of the address
     */
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    /**
     * Gets the postal code of the address.
     *
     * @return the postal code of the address
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the postal code of the address.
     *
     * @param postalCode the new postal code of the address
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Gets the list of doctors associated with the address.
     *
     * @return the list of doctors associated with the address
     */
    public List<DoctorTO> getDoctors() {
        return doctors;
    }

    /**
     * Sets the list of doctors associated with the address.
     *
     * @param doctors the new list of doctors associated with the address
     */
    public void setDoctors(List<DoctorTO> doctors) {
        this.doctors = doctors;
    }

    /**
     * Gets the list of patients associated with the address.
     *
     * @return the list of patients associated with the address
     */
    public List<PatientTO> getPatients() {
        return patients;
    }

    /**
     * Sets the list of patients associated with the address.
     *
     * @param patients the new list of patients associated with the address
     */
    public void setPatients(List<PatientTO> patients) {
        this.patients = patients;
    }
}
