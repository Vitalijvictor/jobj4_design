package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Slivnojs Vitalijs";
        String nationality = "russian";
        String doggyName = "Rex";
        String city = "Antwerpen";
        String land = "Belgium";
        byte age = 43;
        int yearOfBirth = 1978;
        int zipCode = 2018;
        LOG.debug("User info name : {}, age : {}, year of birth : {}, "
                        + "nationality : {}, zip code : {},city : {}, land : "
                        + "{}, doggy name : {}",
                name,
                age, yearOfBirth, nationality, zipCode, city, land, doggyName);
    }
}
