package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;

import java.util.Collection;
import java.util.List;

/**
 * PatientDao is an interface that provides CRUD operations for PatientEntity based on Dao.
 */
public interface PatientDao extends Dao<PatientEntity, Long> {

    /**
     * Finds all patients who have more visits than the specified minimum number of visits.
     *
     * @param minNumberOfVisits the minimum number of visits
     * @return a list of patients who have more visits than the specified minimum number
     */
    List<PatientEntity> findAllPatientsWithMoreVisitsThan(int minNumberOfVisits);

    /**
     * Finds all patients who are older than the specified age.
     *
     * @param age the age to compare
     * @return a list of patients who are older than the specified age
     */
    List<PatientEntity> findPatientsOlderThan(int age);

    /**
     * Finds all patients who are younger than the specified age.
     *
     * @param age the age to compare
     * @return a list of patients who are younger than the specified age
     */
    List<PatientEntity> findPatientsYoungerThan(int age);

    /**
     * Finds patients by their last name.
     *
     * @param lastName the last name to search for
     * @return a collection of objects representing patients with the specified last name
     */
    Collection<Object> findByLastName(String lastName);
}
