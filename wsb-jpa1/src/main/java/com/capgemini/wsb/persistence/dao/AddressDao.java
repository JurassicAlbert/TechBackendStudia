package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.AddressEntity;

import java.util.Optional;

/**
 * AddressDao is an interface that provides CRUD operations for AddressEntity base on Dao.
 */
public interface AddressDao extends Dao<AddressEntity, Long> {
    Optional<AddressEntity> findById(Long id);

    void deleteAll();

    long count();
}