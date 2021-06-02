package com.epam.university.commission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The entry point to the application.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 04/13/2021
 *
 * @author Siarhei Prudnikau1
 */
@SpringBootApplication
public class Application {
    private Application() {
    }

    /**
     * @param args (dummy)
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
