package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.springframework.stereotype.Repository;

/**
 * VisitDaoImpl is an implementation of the VisitDao interface.
 * It provides CRUD operations for VisitEntity.
 */
@Repository
public class VisitDaoImpl extends AbstractDao<VisitEntity, Long> implements VisitDao {

}