package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.util.stream.Collectors;

/**
 * The VisitMapper class provides methods to map between VisitEntity and VisitTO.
 */
public final class VisitMapper {

    private VisitMapper() {
        // Private constructor to prevent instantiation
    }

    /**
     * Maps a VisitEntity to a VisitTO.
     *
     * @param visitEntity the VisitEntity to map
     * @return the mapped VisitTO
     */
    public static VisitTO mapToTO(final VisitEntity visitEntity) {
        if (visitEntity == null) {
            return null;
        }
        final VisitTO visitTO = new VisitTO();
        visitTO.setId(visitEntity.getId());
        visitTO.setDescription(visitEntity.getDescription());
        visitTO.setTime(visitEntity.getTime());
        visitTO.setPatient(PatientMapper.mapToTO(visitEntity.getPatient()));
        visitTO.setDoctor(DoctorMapper.mapToTO(visitEntity.getDoctor()));
        if (visitEntity.getMedicalTreatments() != null) {
            visitTO.setMedicalTreatments(visitEntity.getMedicalTreatments().stream()
                    .map(MedicalTreatmentMapper::mapToTO)
                    .collect(Collectors.toList()));
        }
        return visitTO;
    }

    /**
     * Maps a VisitTO to a VisitEntity.
     *
     * @param visitTO the VisitTO to map
     * @return the mapped VisitEntity
     */
    public static VisitEntity mapToEntity(final VisitTO visitTO) {
        if (visitTO == null) {
            return null;
        }
        final VisitEntity visitEntity = new VisitEntity();
        visitEntity.setId(visitTO.getId());
        visitEntity.setDescription(visitTO.getDescription());
        visitEntity.setTime(visitTO.getTime());
        visitEntity.setPatient(PatientMapper.mapToEntity(visitTO.getPatient()));
        visitEntity.setDoctor(DoctorMapper.mapToEntity(visitTO.getDoctor()));
        if (visitTO.getMedicalTreatments() != null) {
            visitEntity.setMedicalTreatments(visitTO.getMedicalTreatments().stream()
                    .map(MedicalTreatmentMapper::mapToEntity)
                    .collect(Collectors.toList()));
        }
        return visitEntity;
    }
}