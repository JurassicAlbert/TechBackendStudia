package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.AddressTO;

/**
 * Service interface for managing addresses.
 */
public interface AddressService {

    /**
     * Finds an address by its ID.
     *
     * @param id the ID of the address to find
     * @return the found address
     */
    AddressTO findById(Long id);
}
