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

    /**
     * Adds a new address.
     *
     * @param addressTO the address data transfer object
     * @return the added address
     */
    AddressTO addAddress(AddressTO addressTO);

    /**
     * Updates an existing address.
     *
     * @param addressTO the updated address data transfer object
     * @return the updated address
     */
    AddressTO updateAddress(AddressTO addressTO);

    /**
     * Removes an address by its ID.
     *
     * @param id the ID of the address to remove
     */
    void removeAddress(Long id);
}
