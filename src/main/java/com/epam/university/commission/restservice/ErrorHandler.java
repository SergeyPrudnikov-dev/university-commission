package com.epam.university.commission.restservice;

import com.epam.university.commission.exception.DataChangesException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * This class is an error handler.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 06/09/2021
 *
 * @author Siarhei Prudnikau1
 */
@RestController
@ControllerAdvice("com.epam.university.commission.restservice")
public class ErrorHandler {

    /**
     * Handles an exception of type NoSuchElementException.
     *
     * @param exception that is being handled.
     * @return message about exception.
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public final String handleNoSuchElementException(NoSuchElementException exception) {
        return exception.getMessage();
    }

    /**
     * Handles an exception of type MethodArgumentNotValidException.
     *
     * @param exception that is being handled.
     * @return message about exception.
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    /**
     * Handles an exception of type DataChangesException.
     *
     * @param exception that is being handled.
     * @return message about exception.
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataChangesException.class)
    public final String handleExceptionDataChanges(Exception exception) {
        return exception.getMessage();
    }
}
