package com.epam.university.commission.service.impl;

import com.epam.university.commission.domain.Faculty;
import com.epam.university.commission.repository.api.IFacultyRepository;
import com.epam.university.commission.service.api.IFacultyService;

/**
 * This is a method for finding an entity {@link Faculty} in a database by id.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 04/22/2021
 *
 * @author Siarhei Prudnikau1
 */
public class FacultyServiceImpl implements IFacultyService {
    private IFacultyRepository facultyRepository;

    @Override
    public Faculty findById(Long id) {
        return facultyRepository.read(id);
    }
}
