package ru.job4j.serialization.json;

import java.util.Arrays;

public class Guitar {
    private final int strings;
    private final boolean forSale;
    private final Model model;
    private final String brand;
    private final String[] formerOwners;

    public Guitar(int strings, boolean forSale, Model model, String brand, String[] formerOwners) {
        this.strings = strings;
        this.forSale = forSale;
        this.model = model;
        this.brand = brand;
        this.formerOwners = formerOwners;
    }

    @Override
    public String toString() {
        return "Guitar{" + "strings=" + strings + ", forSale=" + forSale + ", model=" + model + ", brand='" + brand + '\'' + ", formerOwners=" + Arrays.toString(formerOwners) + '}';
    }
}
