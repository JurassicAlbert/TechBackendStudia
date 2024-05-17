package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.AddressTO;
import com.capgemini.wsb.mapper.AddressMapper;
import com.capgemini.wsb.persistence.dao.AddressDao;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import com.capgemini.wsb.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service implementation for managing addresses.
 */
@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    private final AddressDao addressDao;

    /**
     * Constructs an AddressServiceImpl with the specified AddressDao.
     *
     * @param pAddressDao the AddressDao to use for data access operations
     */
    @Autowired
    public AddressServiceImpl(AddressDao pAddressDao) {
        this.addressDao = pAddressDao;
    }

    /**
     * Finds an address by its ID.
     *
     * @param id the ID of the address to find
     * @return the found address
     */
    @Override
    public AddressTO findById(Long id) {
        final AddressEntity entity = addressDao.findOne(id);
        return AddressMapper.mapToTO(entity);
    }

    /**
     * Adds a new address.
     *
     * @param addressTO the address data transfer object
     * @return the added address
     */
    @Override
    public AddressTO addAddress(AddressTO addressTO) {
        AddressEntity addressEntity = AddressMapper.mapToEntity(addressTO);
        AddressEntity savedAddress = addressDao.save(addressEntity);
        return AddressMapper.mapToTO(savedAddress);
    }

    /**
     * Updates an existing address.
     *
     * @param addressTO the updated address data transfer object
     * @return the updated address
     */
    @Override
    public AddressTO updateAddress(AddressTO addressTO) {
        AddressEntity addressEntity = AddressMapper.mapToEntity(addressTO);
        AddressEntity updatedAddress = addressDao.update(addressEntity);
        return AddressMapper.mapToTO(updatedAddress);
    }

    /**
     * Removes an address by its ID.
     *
     * @param id the ID of the address to remove
     */
    @Override
    public void removeAddress(Long id) {
        addressDao.delete(id);
    }
}
