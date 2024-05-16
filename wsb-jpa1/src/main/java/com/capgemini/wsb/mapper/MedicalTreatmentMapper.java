package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.MedicalTreatmentTO;
import com.capgemini.wsb.persistence.entity.MedicalTreatmentEntity;

/**
 * The MedicalTreatmentMapper class provides methods to map between MedicalTreatmentEntity and MedicalTreatmentTO.
 */
public final class MedicalTreatmentMapper {

    private MedicalTreatmentMapper() {
        // Private constructor to prevent instantiation
    }

    /**
     * Maps a MedicalTreatmentEntity to a MedicalTreatmentTO.
     *
     * @param medicalTreatmentEntity the MedicalTreatmentEntity to map
     * @return the mapped MedicalTreatmentTO
     */
    public static MedicalTreatmentTO mapToTO(final MedicalTreatmentEntity medicalTreatmentEntity) {
        if (medicalTreatmentEntity == null) {
            return null;
        }
        final MedicalTreatmentTO medicalTreatmentTO = new MedicalTreatmentTO();
        medicalTreatmentTO.setId(medicalTreatmentEntity.getId());
        medicalTreatmentTO.setDescription(medicalTreatmentEntity.getDescription());
        medicalTreatmentTO.setType(medicalTreatmentEntity.getType());
        return medicalTreatmentTO;
    }

    /**
     * Maps a MedicalTreatmentTO to a MedicalTreatmentEntity.
     *
     * @param medicalTreatmentTO the MedicalTreatmentTO to map
     * @return the mapped MedicalTreatmentEntity
     */
    public static MedicalTreatmentEntity mapToEntity(final MedicalTreatmentTO medicalTreatmentTO) {
        if (medicalTreatmentTO == null) {
            return null;
        }
        final MedicalTreatmentEntity medicalTreatmentEntity = new MedicalTreatmentEntity();
        medicalTreatmentEntity.setId(medicalTreatmentTO.getId());
        medicalTreatmentEntity.setDescription(medicalTreatmentTO.getDescription());
        medicalTreatmentEntity.setType(medicalTreatmentTO.getType());
        return medicalTreatmentEntity;
    }
}