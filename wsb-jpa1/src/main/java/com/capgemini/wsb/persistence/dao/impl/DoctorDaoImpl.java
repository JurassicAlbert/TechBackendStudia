package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.DoctorDao;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

/**
 * DoctorDaoImpl is an implementation of the DoctorDao interface.
 * Provides CRUD operations for DoctorEntity.
 */
@Repository
public class DoctorDaoImpl implements DoctorDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<DoctorEntity> findById(Long id) {
        DoctorEntity doctorEntity = entityManager.find(DoctorEntity.class, id);
        return Optional.ofNullable(doctorEntity);
    }

    @Override
    public void deleteAll() {
        entityManager.createQuery("DELETE FROM DoctorEntity").executeUpdate();
    }

    @Override
    public long count() {
        TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(d) FROM DoctorEntity d", Long.class);
        return query.getSingleResult();
    }

    @Override
    public boolean exists(Long id) {
        TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(d) FROM DoctorEntity d WHERE d.id = :id", Long.class);
        query.setParameter("id", id);
        return query.getSingleResult() > 0;
    }

    @Override
    public DoctorEntity save(DoctorEntity doctorEntity) {
        if (doctorEntity.getId() == null) {
            entityManager.persist(doctorEntity);
            entityManager.flush();  // Ensure ID is generated
        } else {
            doctorEntity = entityManager.merge(doctorEntity);
        }
        return doctorEntity;
    }

    @Override
    public DoctorEntity getOne(Long id) {
        return entityManager.getReference(DoctorEntity.class, id);
    }

    @Override
    public DoctorEntity findOne(Long id) {
        return entityManager.find(DoctorEntity.class, id);
    }

    @Override
    public List<DoctorEntity> findAll() {
        TypedQuery<DoctorEntity> query = entityManager.createQuery("SELECT d FROM DoctorEntity d", DoctorEntity.class);
        return query.getResultList();
    }

    @Override
    public DoctorEntity update(DoctorEntity entity) {
        return entityManager.merge(entity);
    }

    @Override
    public void delete(DoctorEntity entity) {
        if (entityManager.contains(entity)) {
            entityManager.remove(entity);
        } else {
            entityManager.remove(entityManager.merge(entity));
        }
    }

    @Override
    public void delete(Long id) {
        DoctorEntity doctorEntity = entityManager.find(DoctorEntity.class, id);
        if (doctorEntity != null) {
            entityManager.remove(doctorEntity);
        }
    }
}
