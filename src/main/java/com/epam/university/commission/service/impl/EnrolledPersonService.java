package com.epam.university.commission.service.impl;

import com.epam.university.commission.domain.EnrolledPerson;
import com.epam.university.commission.repository.api.IEnrolledPersonRepository;
import com.epam.university.commission.service.api.IEnrolledPersonService;

/**
 * This is a method for finding an entity {@link EnrolledPerson} in a database by id.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 04/22/2021
 *
 * @author Siarhei Prudnikau1
 */
public class EnrolledPersonService implements IEnrolledPersonService {
    private IEnrolledPersonRepository enrolledPersonRepository;

    public IEnrolledPersonRepository getEnrolledPersonRepository() {
        return enrolledPersonRepository;
    }

    public void setEnrolledPersonRepository(IEnrolledPersonRepository enrolledPersonRepository) {
        this.enrolledPersonRepository = enrolledPersonRepository;
    }

    @Override
    public EnrolledPerson findById(Long id) {
        return enrolledPersonRepository.read(id);
    }

    /**
     * Saves an object with the given identifier.
     *
     * @param enrolledPerson of the entity.
     */
    @Override
    public void save(EnrolledPerson enrolledPerson) {
        if (enrolledPerson.getId() != null) {
            EnrolledPerson storedEnrolledPerson = enrolledPersonRepository.read(enrolledPerson.getId());
            if (storedEnrolledPerson != null) {
                enrolledPersonRepository.update(enrolledPerson);
            }
        } else {
            enrolledPersonRepository.create(enrolledPerson);
        }
    }

    /**
     * Deletes an object with the given identifier.
     *
     * @param id of the entity.
     */
    @Override
    public void delete(Long id) {
        enrolledPersonRepository.delete(id);
    }
}
