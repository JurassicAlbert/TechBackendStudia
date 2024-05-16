package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.mapper.DoctorMapper;
import com.capgemini.wsb.persistence.dao.DoctorDao;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation for managing doctors.
 */
@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

    private final DoctorDao doctorDao;

    /**
     * Constructs a DoctorServiceImpl with the specified DoctorDao.
     *
     * @param doctorRepository the DoctorDao to use for data access operations
     */
    @Autowired
    public DoctorServiceImpl(DoctorDao doctorRepository) {
        this.doctorDao = doctorRepository;
    }

    /**
     * Finds a doctor by their ID.
     *
     * @param id the ID of the doctor to find
     * @return the found doctor
     */
    @Override
    public DoctorTO findById(Long id) {
        final DoctorEntity doctorEntity = doctorDao.findOne(id);
        return DoctorMapper.mapToTO(doctorEntity);
    }

    /**
     * Adds a new doctor.
     *
     * @param doctorTO the doctor data transfer object
     * @return the added doctor
     */
    @Override
    public DoctorTO addDoctor(DoctorTO doctorTO) {
        DoctorEntity doctorEntity = DoctorMapper.mapToEntity(doctorTO);
        DoctorEntity savedDoctor = doctorDao.save(doctorEntity);
        return DoctorMapper.mapToTO(savedDoctor);
    }

    /**
     * Updates an existing doctor.
     *
     * @param doctorTO the updated doctor data transfer object
     * @return the updated doctor
     */
    @Override
    public DoctorTO updateDoctor(DoctorTO doctorTO) {
        DoctorEntity doctorEntity = DoctorMapper.mapToEntity(doctorTO);
        DoctorEntity updatedDoctor = doctorDao.update(doctorEntity);
        return DoctorMapper.mapToTO(updatedDoctor);
    }

    /**
     * Deletes a doctor by their ID.
     *
     * @param id the ID of the doctor to delete
     */
    @Override
    public void removeDoctor(Long id) {
        doctorDao.delete(id);
    }

    /**
     * Gets the list of all doctors.
     *
     * @return the list of all doctors
     */
    @Override
    public List<DoctorTO> getDoctorList() {
        List<DoctorEntity> doctorEntities = doctorDao.findAll();
        return doctorEntities.stream()
                .map(DoctorMapper::mapToTO)
                .collect(Collectors.toList());
    }

    /**
     * Gets the total number of doctors.
     *
     * @return the total number of doctors
     */
    @Override
    public int DoctorsNumber() {
        final List<DoctorEntity> doctorEntities = doctorDao.findAll();
        return doctorEntities.size();
    }
}
