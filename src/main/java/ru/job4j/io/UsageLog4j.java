package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        char a = '\u0041';
        char name = 'V';
        char nationality = 'R';
        char doggyName = 'T';
        char city = 'A';
        char land = 'B';
        byte age = 43;
        short memCapacity = 16;
        int yearOfBirth = 1978;
        int zipCode = 2018;
        long wtf = 223372455;
        boolean married = true;
        float square = 10.4f;
        double moneySafe = 5.25;
        LOG.debug("A : {}, User info name : {}, age : {}, memCapacity : "
                        + "{}, year " + "of " + "birth : {}, "
                        + "nationality : {}, zip code : {},city : {}, land : "
                        + "{}, doggy name : {}, married : {}, wtf : {}, "
                        + "square : {}, moneySafe : {}",
                a, name,
                age, memCapacity, yearOfBirth, nationality, zipCode, city,
                land, doggyName, married, wtf, square, moneySafe);
    }
}
