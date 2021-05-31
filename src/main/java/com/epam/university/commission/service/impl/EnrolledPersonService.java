package com.epam.university.commission.service.impl;

import com.epam.university.commission.domain.EnrolledPerson;
import com.epam.university.commission.repository.api.IEnrolledPersonRepository;
import com.epam.university.commission.service.api.IEnrolledPersonService;

/**
 * This service contains the basic methods of the service layer for {@link EnrolledPerson} entities.
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

    /**
     * Finds and returns an {@link EnrolledPerson} with the given identifier.
     *
     * @param id is the identifier of the {@link EnrolledPerson}.
     * @return EnrolledPerson - entity.
     */
    @Override
    public EnrolledPerson findById(Long id) {
        return enrolledPersonRepository.read(id);
    }

    /**
     * Saves a given {@link EnrolledPerson}.
     *
     * @param enrolledPerson which is saved.
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
     * Deletes an {@link EnrolledPerson} with the given identifier.
     *
     * @param id is the identifier of the {@link EnrolledPerson}.
     */
    @Override
    public void delete(Long id) {
        enrolledPersonRepository.delete(id);
    }
}
