package com.capgemini.wsb.persistence.entity;

import javax.persistence.*;
import java.util.List;

/**
 * AddressEntity is a JPA entity representing an address.
 * It includes fields for city, address lines, and postal code,
 * and has many-to-many relationships with DoctorEntity and PatientEntity.
 */
@Entity
@Table(name = "ADDRESS")
public class AddressEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "city", nullable = false)
	private String city;

	@Column(name = "addressLine1", nullable = false)
	private String addressLine1;

	@Column(name = "addressLine2")
	private String addressLine2;

	@Column(name = "postalCode", nullable = false)
	private String postalCode;

	@ManyToMany(mappedBy = "addresses")
	private List<DoctorEntity> doctors;

	@ManyToMany(mappedBy = "addresses")
	private List<PatientEntity> patients;

	/**
	 * Gets the ID of the address.
	 *
	 * @return the ID of the address
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the ID of the address.
	 *
	 * @param id the ID to set
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
	 * @param city the city to set
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
	 * @param addressLine1 the first line to set
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
	 * @param addressLine2 the second line to set
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
	 * @param postalCode the postal code to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * Gets the list of doctors associated with the address.
	 *
	 * @return the list of doctors
	 */
	public List<DoctorEntity> getDoctors() {
		return doctors;
	}

	/**
	 * Sets the list of doctors associated with the address.
	 *
	 * @param doctors the list of doctors to set
	 */
	public void setDoctors(List<DoctorEntity> doctors) {
		this.doctors = doctors;
	}

	/**
	 * Gets the list of patients associated with the address.
	 *
	 * @return the list of patients
	 */
	public List<PatientEntity> getPatients() {
		return patients;
	}

	/**
	 * Sets the list of patients associated with the address.
	 *
	 * @param patients the list of patients to set
	 */
	public void setPatients(List<PatientEntity> patients) {
		this.patients = patients;
	}

	public AddressEntity() {
		// Default constructor
	}
}