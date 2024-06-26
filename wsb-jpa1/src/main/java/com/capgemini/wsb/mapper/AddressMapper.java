package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.AddressTO;
import com.capgemini.wsb.persistence.entity.AddressEntity;

import java.util.stream.Collectors;

/**
 * The AddressMapper class provides methods to map between AddressEntity and AddressTO.
 */
public final class AddressMapper {

    private AddressMapper() {
        // Private constructor to prevent instantiation
    }

    /**
     * Maps an AddressEntity to an AddressTO.
     *
     * @param addressEntity the AddressEntity to map
     * @return the mapped AddressTO
     */
    public static AddressTO mapToTO(final AddressEntity addressEntity) {
        if (addressEntity == null) {
            return null;
        }
        final AddressTO addressTO = new AddressTO();
        addressTO.setId(addressEntity.getId());
        addressTO.setAddressLine1(addressEntity.getAddressLine1());
        addressTO.setAddressLine2(addressEntity.getAddressLine2());
        addressTO.setCity(addressEntity.getCity());
        addressTO.setPostalCode(addressEntity.getPostalCode());
        if (addressEntity.getPatients() != null) {
            addressTO.setPatients(addressEntity.getPatients().stream()
                    .map(PatientMapper::mapToTO)
                    .collect(Collectors.toList()));
        }
        if (addressEntity.getDoctors() != null) {
            addressTO.setDoctors(addressEntity.getDoctors().stream()
                    .map(DoctorMapper::mapToTO)
                    .collect(Collectors.toList()));
        }
        return addressTO;
    }

    /**
     * Maps an AddressTO to an AddressEntity.
     *
     * @param addressTO the AddressTO to map
     * @return the mapped AddressEntity
     */
    public static AddressEntity mapToEntity(final AddressTO addressTO) {
        if (addressTO == null) {
            return null;
        }
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setId(addressTO.getId());
        addressEntity.setAddressLine1(addressTO.getAddressLine1());
        addressEntity.setAddressLine2(addressTO.getAddressLine2());
        addressEntity.setCity(addressTO.getCity());
        addressEntity.setPostalCode(addressTO.getPostalCode());
        if (addressTO.getDoctors() != null) {
            addressEntity.setDoctors(addressTO.getDoctors().stream()
                    .map(DoctorMapper::mapToEntity)
                    .collect(Collectors.toList()));
        }
        if (addressTO.getPatients() != null) {
            addressEntity.setPatients(addressTO.getPatients().stream()
                    .map(PatientMapper::mapToEntity)
                    .collect(Collectors.toList()));
        }
        return addressEntity;
    }
}