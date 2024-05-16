package com.capgemini.wsb.persistence.entity;

import com.capgemini.wsb.persistence.enums.Specialization;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

/**
 * DoctorEntity is a JPA entity representing a doctor.
 * It includes fields for personal details and specialization,
 * and has relationships with AddressEntity and VisitEntity.
 */
@Entity
@Table(name = "DOCTOR")
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "telephoneNumber", nullable = false)
    private String telephoneNumber;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "doctorNumber", nullable = false)
    private String doctorNumber;

    @Column(name = "specialization", nullable = false)
    @Enumerated(EnumType.STRING)
    private Specialization specialization;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "DOCTOR_ADDRESS_MAPPING",
            joinColumns = @JoinColumn(name = "DOCTOR_ID"),
            inverseJoinColumns = @JoinColumn(name = "ADDRESS_ID")
    )
    private List<AddressEntity> addresses;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<VisitEntity> visits;

    /**
     * Gets the ID of the doctor.
     *
     * @return the ID of the doctor
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the doctor.
     *
     * @param id the ID to set
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
     * @param firstName the first name to set
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
     * @param lastName the last name to set
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
     * @param telephoneNumber the telephone number to set
     */
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    /**
     * Gets the email of the doctor.
     *
     * @return the email of the doctor
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the doctor.
     *
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the doctor number.
     *
     * @return the doctor number
     */
    public String getDoctorNumber() {
        return doctorNumber;
    }

    /**
     * Sets the doctor number.
     *
     * @param doctorNumber the doctor number to set
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
     * @param specialization the specialization to set
     */
    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    /**
     * Gets the list of addresses associated with the doctor.
     *
     * @return the list of addresses
     */
    public List<AddressEntity> getAddresses() {
        return addresses;
    }

    /**
     * Sets the list of addresses associated with the doctor.
     *
     * @param addresses the list of addresses to set
     */
    public void setAddresses(List<AddressEntity> addresses) {
        this.addresses = addresses;
    }

    /**
     * Gets the list of visits associated with the doctor.
     *
     * @return the list of visits
     */
    public List<VisitEntity> getVisits() {
        return visits;
    }

    /**
     * Sets the list of visits associated with the doctor.
     *
     * @param visits the list of visits to set
     */
    public void setVisits(List<VisitEntity> visits) {
        this.visits = visits;
    }
}