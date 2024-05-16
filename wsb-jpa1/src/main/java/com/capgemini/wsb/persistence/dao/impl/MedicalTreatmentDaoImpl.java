package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.MedicalTreatmentDao;
import com.capgemini.wsb.persistence.entity.MedicalTreatmentEntity;
import org.springframework.stereotype.Repository;

/**
 * MedicalTreatmentDaoImpl is an implementation of the MedicalTreatmentDao interface.
 * Provides CRUD operations for MedicalTreatmentEntity.
 */
@Repository
public class MedicalTreatmentDaoImpl extends AbstractDao<MedicalTreatmentEntity, Long> implements MedicalTreatmentDao {

}