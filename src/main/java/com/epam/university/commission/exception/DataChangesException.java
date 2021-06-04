package com.epam.university.commission.exception;

/**
 * This exception is thrown if the data could not be changed successfully.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 06/09/2021
 *
 * @author Siarhei Prudnikau1
 */
public class DataChangesException extends RuntimeException {
    /**
     * This is a constructor.
     *
     * @param message about exception.
     */
    public DataChangesException(String message) {
        super(message);
    }
}
