package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.AddressDao;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import org.springframework.stereotype.Repository;

/**
 * AddressDaoImpl is an implementation of the AddressDao interface.
 * Provides CRUD operations for AddressEntity.
 */
@Repository
public class AddressDaoImpl extends AbstractDao<AddressEntity, Long> implements AddressDao {

}