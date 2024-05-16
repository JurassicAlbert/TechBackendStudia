package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.persistence.entity.DoctorEntity;

import java.util.stream.Collectors;

/**
 * The DoctorMapper class provides methods to map between DoctorEntity and DoctorTO.
 */
public final class DoctorMapper {

    private DoctorMapper() {
        // Private constructor to prevent instantiation
    }

    /**
     * Maps a DoctorEntity to a DoctorTO.
     *
     * @param doctorEntity the DoctorEntity to map
     * @return the mapped DoctorTO
     */
    public static DoctorTO mapToTO(final DoctorEntity doctorEntity) {
        if (doctorEntity == null) {
            return null;
        }
        final DoctorTO doctorTO = new DoctorTO();
        doctorTO.setId(doctorEntity.getId());
        doctorTO.setFirstName(doctorEntity.getFirstName());
        doctorTO.setLastName(doctorEntity.getLastName());
        doctorTO.setTelephoneNumber(doctorEntity.getTelephoneNumber());
        doctorTO.setEmail(doctorEntity.getEmail());
        doctorTO.setDoctorNumber(doctorEntity.getDoctorNumber());
        doctorTO.setSpecialization(doctorEntity.getSpecialization());
        if (doctorEntity.getAddresses() != null) {
            doctorTO.setAddresses(doctorEntity.getAddresses().stream()
                    .map(AddressMapper::mapToTO)
                    .collect(Collectors.toList()));
        }
        if (doctorEntity.getVisits() != null) {
            doctorTO.setVisits(doctorEntity.getVisits().stream()
                    .map(VisitMapper::mapToTO)
                    .collect(Collectors.toList()));
        }
        return doctorTO;
    }

    /**
     * Maps a DoctorTO to a DoctorEntity.
     *
     * @param doctorTO the DoctorTO to map
     * @return the mapped DoctorEntity
     */
    public static DoctorEntity mapToEntity(final DoctorTO doctorTO) {
        if (doctorTO == null) {
            return null;
        }
        final DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setId(doctorTO.getId());
        doctorEntity.setFirstName(doctorTO.getFirstName());
        doctorEntity.setLastName(doctorTO.getLastName());
        doctorEntity.setTelephoneNumber(doctorTO.getTelephoneNumber());
        doctorEntity.setEmail(doctorTO.getEmail());
        doctorEntity.setDoctorNumber(doctorTO.getDoctorNumber());
        doctorEntity.setSpecialization(doctorTO.getSpecialization());
        if (doctorTO.getAddresses() != null) {
            doctorEntity.setAddresses(doctorTO.getAddresses().stream()
                    .map(AddressMapper::mapToEntity)
                    .collect(Collectors.toList()));
        }
        if (doctorTO.getVisits() != null) {
            doctorEntity.setVisits(doctorTO.getVisits().stream()
                    .map(VisitMapper::mapToEntity)
                    .collect(Collectors.toList()));
        }
        return doctorEntity;
    }
}