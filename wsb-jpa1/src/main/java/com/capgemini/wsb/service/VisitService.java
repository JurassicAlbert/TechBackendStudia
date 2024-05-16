package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.VisitTO;

import java.util.List;

/**
 * Service interface for managing visits.
 */
public interface VisitService {

    /**
     * Finds a visit by its ID.
     *
     * @param id the ID of the visit to find
     * @return the found visit
     */
    VisitTO findById(Long id);

    /**
     * Adds a new visit.
     *
     * @param visitTO the visit data transfer object
     * @return the added visit
     */
    VisitTO addVisit(VisitTO visitTO);

    /**
     * Updates an existing visit.
     *
     * @param visitTO the updated visit data transfer object
     * @return the updated visit
     */
    VisitTO updateVisit(VisitTO visitTO);

    /**
     * Deletes a visit by its ID.
     *
     * @param id the ID of the visit to delete
     */
    void removeVisit(Long id);

    /**
     * Gets the list of all visits.
     *
     * @return the list of all visits
     */
    List<VisitTO> findAllVisits();
}
