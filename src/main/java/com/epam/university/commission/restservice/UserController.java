package com.epam.university.commission.restservice;

import com.epam.university.commission.domain.User;
import com.epam.university.commission.service.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Rest controller for working with {@link User}.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 06/03/2021
 *
 * @author Siarhei Prudnikau1
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private IUserService userService;

    /**
     * Creates a given {@link User}.
     *
     * @param user which is created.
     * @return he ResponseEntity(sets the body, status, and headers of the HTTP response).
     */
    @PostMapping()
    public ResponseEntity<Long> create(@Valid @RequestBody User user) {
        userService.save(user);
        return new ResponseEntity<>(user.getId(), HttpStatus.CREATED);
    }

    /**
     * Finds a {@link User} with the given identifier and returns its parameters as a ResponseEntity.
     *
     * @param id is the identifier of the {@link User}.
     * @return The ResponseEntity(sets the body, status, and headers of the HTTP response).
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> read(@PathVariable("id") long id) {
        final User user = userService.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * Updates a given {@link User}.
     *
     * @param user which is updated.
     * @return The ResponseEntity(sets the body, status, and headers of the HTTP response).
     */
    @PutMapping()
    public ResponseEntity<?> update(@RequestBody User user) {
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Deletes {@link User} with the given identifier.
     *
     * @param id is the identifier of the {@link User}.
     * @return The ResponseEntity(sets the body, status, and headers of the HTTP response).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
