package ru.job4j.serialization.json;

/**
 * JSON (JavaScript Object Notation)
 */
public class Contact {
    private final String phone;

    public Contact(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact{"
                + "phone='" + phone + '\''
                + '}';
    }
}