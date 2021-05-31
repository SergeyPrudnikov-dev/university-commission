package com.epam.university.commission.service.impl;

import com.epam.university.commission.domain.Faculty;
import com.epam.university.commission.repository.api.IFacultyRepository;
import com.epam.university.commission.service.api.IFacultyService;

/**
 * This service contains the basic methods of the service layer for {@link Faculty} entities.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 04/22/2021
 *
 * @author Siarhei Prudnikau1
 */
public class FacultyService implements IFacultyService {
    private IFacultyRepository facultyRepository;

    public IFacultyRepository getFacultyRepository() {
        return facultyRepository;
    }

    public void setFacultyRepository(IFacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    /**
     * Finds and returns an {@link Faculty} with the given identifier.
     *
     * @param id is the identifier of the {@link Faculty}.
     * @return Faculty - entity.
     */
    @Override
    public Faculty findById(Long id) {
        return facultyRepository.read(id);
    }

    /**
     * Saves a given {@link Faculty}.
     *
     * @param faculty which is saved.
     */
    @Override
    public void save(Faculty faculty) {
        if (faculty.getId() != null) {
            Faculty storedFaculty = facultyRepository.read(faculty.getId());
            if (storedFaculty != null) {
                facultyRepository.update(faculty);
            }
        } else {
            facultyRepository.create(faculty);
        }
    }

    /**
     * Deletes an {@link Faculty} with the given identifier.
     *
     * @param id is the identifier of the {@link Faculty}.
     */
    @Override
    public void delete(Long id) {
        facultyRepository.delete(id);
    }
}
