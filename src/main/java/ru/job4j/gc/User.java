package ru.job4j.gc;

public class User {
    private String street;
    private int homeNumber;

    public User(String street, int homeNumber) {
        this.street = street;
        this.homeNumber = homeNumber;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %d %s%n", street, homeNumber);
    }
}
