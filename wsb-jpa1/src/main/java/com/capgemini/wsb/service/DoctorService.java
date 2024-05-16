package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.DoctorTO;

import java.util.List;

/**
 * Service interface for managing doctors.
 */
public interface DoctorService {

    /**
     * Finds a doctor by their ID.
     *
     * @param id the ID of the doctor to find
     * @return the found doctor
     */
    DoctorTO findById(Long id);

    /**
     * Adds a new doctor.
     *
     * @param doctorTO the doctor data transfer object
     * @return the added doctor
     */
    DoctorTO addDoctor(DoctorTO doctorTO);

    /**
     * Updates an existing doctor.
     *
     * @param doctorTO the updated doctor data transfer object
     * @return the updated doctor
     */
    DoctorTO updateDoctor(DoctorTO doctorTO);

    /**
     * Deletes a doctor by their ID.
     *
     * @param id the ID of the doctor to delete
     */
    void removeDoctor(Long id);

    /**
     * Gets the list of all doctors.
     *
     * @return the list of all doctors
     */
    List<DoctorTO> getDoctorList();

    int DoctorsNumber();
}
