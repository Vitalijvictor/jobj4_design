package ru.job4j.serialization.xml;

public class Temper {
    private final String temper;

    public Temper(String temper) {
        this.temper = temper;
    }

    public String getTemper() {
        return temper;
    }

    @Override
    public String toString() {
        return "Temper{" + "temper='" + temper + '\'' + '}';
    }
}
