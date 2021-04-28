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
public class FacultyService implements IFacultyService {
    private IFacultyRepository facultyRepository;

    public IFacultyRepository getFacultyRepository() {
        return facultyRepository;
    }

    public void setFacultyRepository(IFacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Faculty findById(Long id) {
        return facultyRepository.read(id);
    }

    /**
     * Saves an object with the given identifier.
     *
     * @param faculty of the entity.
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
     * Deletes an object with the given identifier.
     *
     * @param id of the entity.
     */
    @Override
    public void delete(Long id) {
        facultyRepository.delete(id);
    }
}
