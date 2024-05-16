package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.mapper.VisitMapper;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.service.PatientService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation for managing patients.
 */
@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    private final PatientDao patientDao;

    /**
     * Constructs a PatientServiceImpl with the specified PatientDao.
     *
     * @param patientRepository the PatientDao to use for data access operations
     */
    @Autowired
    public PatientServiceImpl(PatientDao patientRepository) {
        this.patientDao = patientRepository;
    }

    /**
     * Finds a patient by its ID.
     *
     * @param id the ID of the patient to find
     * @return the found patient
     */
    @Override
    public PatientTO findById(Long id) {
        final PatientEntity patientEntity = patientDao.findOne(id);
        return PatientMapper.mapToTO(patientEntity);
    }

    /**
     * Adds a new patient.
     *
     * @param patientTO the patient data transfer object
     * @return the added patient
     */
    @Override
    @Transactional
    public PatientTO addPatient(PatientTO patientTO) {
        PatientEntity patientEntity = PatientMapper.mapToEntity(patientTO);
        PatientEntity savedPatient = patientDao.save(patientEntity);
        return PatientMapper.mapToTO(savedPatient);
    }

    /**
     * Removes a patient by its ID.
     *
     * @param patientId the ID of the patient to remove
     */
    @Override
    public void removePatient(Long patientId) {
        patientDao.delete(patientId);
    }

    /**
     * Updates an existing patient.
     *
     * @param patientTO the updated patient data transfer object
     * @return the updated patient
     */
    @Override
    public PatientTO updatePatient(PatientTO patientTO) {
        PatientEntity patientEntity = PatientMapper.mapToEntity(patientTO);
        patientDao.update(patientEntity);
        return PatientMapper.mapToTO(patientEntity);
    }

    /**
     * Gets all visits for a specific patient.
     *
     * @param patientId the ID of the patient
     * @return the list of visits for the patient
     */
    @Override
    public List<VisitTO> getAllVisitsForPatient(Long patientId) {
        PatientEntity patientEntity = patientDao.findOne(patientId);
        List<VisitEntity> visitEntities = patientEntity.getVisits();
        return visitEntities.stream()
                .map(VisitMapper::mapToTO)
                .collect(Collectors.toList());
    }

    /**
     * Gets a patient with their visits.
     *
     * @param patientId the ID of the patient
     * @return the patient with their visits
     */
    @Override
    @Transactional(readOnly = true)
    public PatientTO getPatientWithVisits(Long patientId) {
        PatientEntity patientEntity = patientDao.findOne(patientId);
        Hibernate.initialize(patientEntity.getVisits());
        return PatientMapper.mapToTO(patientEntity);
    }

    /**
     * Gets the list of all patients.
     *
     * @return the list of all patients
     */
    @Override
    public List<PatientTO> getPatientList() {
        List<PatientEntity> patientList = patientDao.findAll();
        return patientList.stream().map(PatientMapper::mapToTO).collect(Collectors.toList());
    }
}