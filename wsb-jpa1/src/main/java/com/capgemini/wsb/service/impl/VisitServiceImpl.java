package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.mapper.VisitMapper;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the VisitService interface for managing visits.
 */
@Service
@Transactional
public class VisitServiceImpl implements VisitService {

    private final VisitDao visitDao;

    /**
     * Constructs a VisitServiceImpl with the specified VisitDao.
     *
     * @param visitDao the VisitDao to use for data access operations
     */
    @Autowired
    public VisitServiceImpl(VisitDao visitDao) {
        this.visitDao = visitDao;
    }

    /**
     * Finds a visit by its ID.
     *
     * @param id the ID of the visit to find
     * @return the found visit
     */
    @Override
    public VisitTO findById(Long id) {
        final VisitEntity visitEntity = visitDao.findOne(id);
        return VisitMapper.mapToTO(visitEntity);
    }

    /**
     * Finds all visits.
     *
     * @return the list of all visits
     */
    @Override
    public List<VisitTO> findAllVisits() {
        final List<VisitEntity> visits = visitDao.findAll();
        return visits.stream().map(VisitMapper::mapToTO).collect(Collectors.toList());
    }

    /**
     * Adds a new visit.
     *
     * @param visitTO the visit data transfer object
     * @return the added visit
     */
    @Override
    public VisitTO addVisit(VisitTO visitTO) {
        VisitEntity visitEntity = VisitMapper.mapToEntity(visitTO);
        VisitEntity savedVisit = visitDao.save(visitEntity);
        return VisitMapper.mapToTO(savedVisit);
    }

    /**
     * Updates an existing visit.
     *
     * @param visitTO the updated visit data transfer object
     * @return the updated visit
     */
    @Override
    public VisitTO updateVisit(VisitTO visitTO) {
        VisitEntity visitEntity = VisitMapper.mapToEntity(visitTO);
        VisitEntity updatedVisit = visitDao.update(visitEntity);
        return VisitMapper.mapToTO(updatedVisit);
    }

    /**
     * Removes a visit by its ID.
     *
     * @param id the ID of the visit to remove
     */
    @Override
    public void removeVisit(Long id) {
        visitDao.delete(id);
    }
}
