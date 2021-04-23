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
public class EnrolledPersonServiceImpl implements IEnrolledPersonService {
    private IEnrolledPersonRepository enrolledPersonRepository;

    @Override
    public EnrolledPerson findById(Long id) {
        return enrolledPersonRepository.read(id);
    }
}
