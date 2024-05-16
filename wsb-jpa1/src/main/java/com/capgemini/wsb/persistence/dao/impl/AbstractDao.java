package com.capgemini.wsb.persistence.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.capgemini.wsb.persistence.dao.Dao;
import org.springframework.transaction.annotation.Transactional;

/**
 * AbstractDao is an abstract class that provides common data access methods for entity management.
 *
 * @param <T> the type of the entity
 * @param <K> the type of the entity's identifier
 */
@Transactional
public abstract class AbstractDao<T, K extends Serializable> implements Dao<T, K> {

    @PersistenceContext
    protected EntityManager entityManager;

    private Class<T> domainClass;

    /**
     * Saves the given entity to the database.
     *
     * @param entity the entity to save
     * @return the saved entity
     */
    @Override
    public T save(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    /**
     * Retrieves an entity by its identifier without initializing its properties.
     *
     * @param id the identifier of the entity
     * @return the entity reference
     */
    @Override
    public T getOne(K id) {
        return entityManager.getReference(getDomainClass(), id);
    }

    /**
     * Retrieves an entity by its identifier.
     *
     * @param id the identifier of the entity
     * @return the found entity or null if not found
     */
    @Override
    public T findOne(K id) {
        return entityManager.find(getDomainClass(), id);
    }

    /**
     * Retrieves all entities of the domain class.
     *
     * @return a list of all entities
     */
    @Override
    public List<T> findAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = builder.createQuery(getDomainClass());
        criteriaQuery.from(getDomainClass());
        TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    /**
     * Updates the given entity in the database.
     *
     * @param entity the entity to update
     * @return the updated entity
     */
    @Override
    public T update(T entity) {
        return entityManager.merge(entity);
    }

    /**
     * Deletes the given entity from the database.
     *
     * @param entity the entity to delete
     */
    @Override
    public void delete(T entity) {
        entityManager.remove(entity);
    }

    /**
     * Deletes an entity by its identifier.
     *
     * @param id the identifier of the entity to delete
     */
    @Override
    public void delete(K id) {
        entityManager.remove(getOne(id));
    }

    /**
     * Deletes all entities of the domain class.
     */
    @Override
    public void deleteAll() {
        entityManager.createQuery("delete from " + getDomainClassName()).executeUpdate();
    }

    /**
     * Counts the total number of entities of the domain class.
     *
     * @return the total number of entities
     */
    @Override
    public long count() {
        return (long) entityManager.createQuery("Select count(*) from " + getDomainClassName()).getSingleResult();
    }

    /**
     * Checks if an entity with the given identifier exists.
     *
     * @param id the identifier of the entity
     * @return true if the entity exists, false otherwise
     */
    @Override
    public boolean exists(K id) {
        return findOne(id) != null;
    }

    /**
     * Retrieves the domain class of the entity.
     *
     * @return the domain class
     */
    @SuppressWarnings("unchecked")
    protected Class<T> getDomainClass() {
        if (domainClass == null) {
            ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
            domainClass = (Class<T>) type.getActualTypeArguments()[0];
        }
        return domainClass;
    }

    /**
     * Retrieves the name of the domain class.
     *
     * @return the name of the domain class
     */
    protected String getDomainClassName() {
        return getDomainClass().getName();
    }
}