package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.DoctorEntity;

import java.util.Optional;

/**
 * DoctorDao is an interface that provides CRUD operations for DoctorEntity based on Dao.
 */
public interface DoctorDao extends Dao<DoctorEntity, Long> {
    Optional<DoctorEntity> findById(Long id);
}
