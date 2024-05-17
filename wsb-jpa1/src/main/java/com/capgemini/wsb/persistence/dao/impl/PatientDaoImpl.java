package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;

/**
 * PatientDaoImpl is an implementation of the PatientDao interface.
 * Provides CRUD operations for PatientEntity.
 */
@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    /**
     * Finds all patients who have more visits than the specified minimum number of visits.
     *
     * @param minNumberOfVisits the minimum number of visits
     * @return a list of patients who have more visits than the specified minimum number
     */
    @Override
    public List<PatientEntity> findAllPatientsWithMoreVisitsThan(int minNumberOfVisits) {
        TypedQuery<PatientEntity> query = entityManager.createQuery(
                "SELECT p FROM PatientEntity p WHERE size(p.visits) > :minNumberOfVisits", PatientEntity.class);
        query.setParameter("minNumberOfVisits", minNumberOfVisits);
        return query.getResultList();
    }

    /**
     * Finds all patients who are older than the specified age.
     *
     * @param age the age to compare
     * @return a list of patients who are older than the specified age
     */
    @Override
    public List<PatientEntity> findPatientsOlderThan(int age) {
        TypedQuery<PatientEntity> query = entityManager.createQuery(
                "SELECT p FROM PatientEntity p WHERE YEAR(CURRENT_DATE) - YEAR(p.dateOfBirth) > :age", PatientEntity.class);
        query.setParameter("age", age);
        return query.getResultList();
    }

    /**
     * Finds all patients who are younger than the specified age.
     *
     * @param age the age to compare
     * @return a list of patients who are younger than the specified age
     */
    @Override
    public List<PatientEntity> findPatientsYoungerThan(int age) {
        TypedQuery<PatientEntity> query = entityManager.createQuery(
                "SELECT p FROM PatientEntity p WHERE YEAR(CURRENT_DATE) - YEAR(p.dateOfBirth) < :age", PatientEntity.class);
        query.setParameter("age", age);
        return query.getResultList();
    }

    /**
     * Finds patients by their last name.
     *
     * @param lastName the last name to search for
     * @return a collection of objects representing patients with the specified last name
     */
    @Override
    public Collection<Object> findByLastName(String lastName) {
        TypedQuery<Object> query = entityManager.createQuery(
                "SELECT p FROM PatientEntity p WHERE p.lastName = :lastName", Object.class);
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }
}
