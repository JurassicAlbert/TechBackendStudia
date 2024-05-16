package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.MedicalTreatmentTO;
import com.capgemini.wsb.mapper.MedicalTreatmentMapper;
import com.capgemini.wsb.persistence.dao.MedicalTreatmentDao;
import com.capgemini.wsb.persistence.entity.MedicalTreatmentEntity;
import com.capgemini.wsb.service.MedicalTreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation for managing medical treatments.
 */
@Service
@Transactional
public class MedicalTreatmentServiceImpl implements MedicalTreatmentService {

    private final MedicalTreatmentDao medicalTreatmentDao;

    /**
     * Constructs a MedicalTreatmentServiceImpl with the specified MedicalTreatmentDao.
     *
     * @param medicalTreatmentRepository the MedicalTreatmentDao to use for data access operations
     */
    @Autowired
    public MedicalTreatmentServiceImpl(MedicalTreatmentDao medicalTreatmentRepository) {
        this.medicalTreatmentDao = medicalTreatmentRepository;
    }

    /**
     * Finds a medical treatment by its ID.
     *
     * @param id the ID of the medical treatment to find
     * @return the found medical treatment
     */
    @Override
    public MedicalTreatmentTO findById(Long id) {
        final MedicalTreatmentEntity medicalTreatmentEntity = medicalTreatmentDao.findOne(id);
        return MedicalTreatmentMapper.mapToTO(medicalTreatmentEntity);
    }

    /**
     * Adds a new medical treatment.
     *
     * @param medicalTreatmentTO the medical treatment data transfer object
     * @return the added medical treatment
     */
    @Override
    public MedicalTreatmentTO addMedicalTreatment(MedicalTreatmentTO medicalTreatmentTO) {
        MedicalTreatmentEntity medicalTreatmentEntity = MedicalTreatmentMapper.mapToEntity(medicalTreatmentTO);
        MedicalTreatmentEntity savedMedicalTreatment = medicalTreatmentDao.save(medicalTreatmentEntity);
        return MedicalTreatmentMapper.mapToTO(savedMedicalTreatment);
    }

    /**
     * Updates an existing medical treatment.
     *
     * @param medicalTreatmentTO the updated medical treatment data transfer object
     * @return the updated medical treatment
     */
    @Override
    public MedicalTreatmentTO updateMedicalTreatment(MedicalTreatmentTO medicalTreatmentTO) {
        MedicalTreatmentEntity medicalTreatmentEntity = MedicalTreatmentMapper.mapToEntity(medicalTreatmentTO);
        MedicalTreatmentEntity updatedMedicalTreatment = medicalTreatmentDao.update(medicalTreatmentEntity);
        return MedicalTreatmentMapper.mapToTO(updatedMedicalTreatment);
    }

    /**
     * Deletes a medical treatment by its ID.
     *
     * @param id the ID of the medical treatment to delete
     */
    @Override
    public void removeMedicalTreatment(Long id) {
        medicalTreatmentDao.delete(id);
    }

    /**
     * Gets the list of all medical treatments.
     *
     * @return the list of all medical treatments
     */
    @Override
    public List<MedicalTreatmentTO> getMedicalTreatmentList() {
        List<MedicalTreatmentEntity> medicalTreatmentList = medicalTreatmentDao.findAll();
        return medicalTreatmentList.stream()
                .map(MedicalTreatmentMapper::mapToTO)
                .collect(Collectors.toList());
    }
}
