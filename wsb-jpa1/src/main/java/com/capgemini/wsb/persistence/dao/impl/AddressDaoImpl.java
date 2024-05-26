package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.AddressDao;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class AddressDaoImpl implements AddressDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<AddressEntity> findById(Long id) {
        AddressEntity addressEntity = entityManager.find(AddressEntity.class, id);
        return Optional.ofNullable(addressEntity);
    }

    @Override
    public void deleteAll() {
        entityManager.createQuery("DELETE FROM AddressEntity").executeUpdate();
    }

    @Override
    public long count() {
        TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(a) FROM AddressEntity a", Long.class);
        return query.getSingleResult();
    }

    @Override
    public boolean exists(Long id) {
        TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(a) FROM AddressEntity a WHERE a.id = :id", Long.class);
        query.setParameter("id", id);
        return query.getSingleResult() > 0;
    }

    @Override
    public AddressEntity save(AddressEntity addressEntity) {
        if (addressEntity.getId() == null) {
            entityManager.persist(addressEntity);
            entityManager.flush();  // Ensure ID is generated
        } else {
            entityManager.merge(addressEntity);
        }
        return addressEntity;
    }

    @Override
    public AddressEntity getOne(Long id) {
        return entityManager.getReference(AddressEntity.class, id);
    }

    @Override
    public AddressEntity findOne(Long id) {
        return entityManager.find(AddressEntity.class, id);
    }

    @Override
    public List<AddressEntity> findAll() {
        TypedQuery<AddressEntity> query = entityManager.createQuery("SELECT a FROM AddressEntity a", AddressEntity.class);
        return query.getResultList();
    }

    @Override
    public AddressEntity update(AddressEntity entity) {
        return entityManager.merge(entity);
    }

    @Override
    public void delete(AddressEntity entity) {
        if (entityManager.contains(entity)) {
            entityManager.remove(entity);
        } else {
            entityManager.remove(entityManager.merge(entity));
        }
    }

    @Override
    public void delete(Long id) {
        AddressEntity addressEntity = entityManager.find(AddressEntity.class, id);
        if (addressEntity != null) {
            entityManager.remove(addressEntity);
        }
    }
}
