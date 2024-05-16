package com.capgemini.wsb.persistence.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

/**
 * PatientEntity is a JPA entity representing a patient.
 * It includes fields for patient's personal information,
 * such as name, contact details, patient number, date of birth, and insurance status.
 * It has relationships with AddressEntity and VisitEntity.
 */
@Entity
@Table(name = "PATIENT")
public class PatientEntity {

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

	@Column(name = "patientNumber", nullable = false)
	private String patientNumber;

	@Column(name = "dateOfBirth", nullable = false)
	private LocalDate dateOfBirth;

	@Column(name = "hasInsurance", nullable = false)
	private boolean hasInsurance;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinTable(
			name = "PATIENT_ADDRESS_MAPPING",
			joinColumns = @JoinColumn(name = "PATIENT_ID"),
			inverseJoinColumns = @JoinColumn(name = "ADDRESS_ID")
	)
	private List<AddressEntity> addresses;

	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<VisitEntity> visits;

	/**
	 * Gets the ID of the patient.
	 *
	 * @return the ID of the patient
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the ID of the patient.
	 *
	 * @param id the ID to set
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
	 * @param firstName the first name to set
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
	 * @param lastName the last name to set
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
	 * @param telephoneNumber the telephone number to set
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
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the patient number.
	 *
	 * @return the patient number
	 */
	public String getPatientNumber() {
		return patientNumber;
	}

	/**
	 * Sets the patient number.
	 *
	 * @param patientNumber the patient number to set
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
	 * @param dateOfBirth the date of birth to set
	 */
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * Gets the addresses associated with the patient.
	 *
	 * @return the addresses associated with the patient
	 */
	public List<AddressEntity> getAddresses() {
		return addresses;
	}

	/**
	 * Sets the addresses associated with the patient.
	 *
	 * @param addresses the addresses to set
	 */
	public void setAddresses(List<AddressEntity> addresses) {
		this.addresses = addresses;
	}

	/**
	 * Gets the visits associated with the patient.
	 *
	 * @return the visits associated with the patient
	 */
	public List<VisitEntity> getVisits() {
		return visits;
	}

	/**
	 * Sets the visits associated with the patient.
	 *
	 * @param visits the visits to set
	 */
	public void setVisits(List<VisitEntity> visits) {
		this.visits = visits;
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
	 * @param hasInsurance the insurance status to set
	 */
	public void setHasInsurance(boolean hasInsurance) {
		this.hasInsurance = hasInsurance;
	}
}