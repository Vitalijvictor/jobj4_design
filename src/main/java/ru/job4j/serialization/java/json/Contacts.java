package ru.job4j.serialization.java.json;

/**
 * JSON (JavaScript Object Notation)
 */
public class Contacts {
    private final String phone;

    public Contacts(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact{"
                + "phone='" + phone + '\''
                + '}';
    }
}