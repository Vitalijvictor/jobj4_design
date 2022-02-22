package ru.job4j.serialization.json;

import java.util.Arrays;

public class Guitar {
    private int strings;
    private boolean forSale;
    private Model model;
    private String brand;
    private String[] formerOwners;

    public Guitar() {
    }

    public Guitar(int strings, boolean forSale, Model model, String brand, String[] formerOwners) {
        this.strings = strings;
        this.forSale = forSale;
        this.model = model;
        this.brand = brand;
        this.formerOwners = formerOwners;
    }

    public int getStrings() {
        return strings;
    }

    public boolean isForSale() {
        return forSale;
    }

    public Model getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public String[] getFormerOwners() {
        return formerOwners;
    }

    public void setStrings(int strings) {
        this.strings = strings;
    }

    public void setForSale(boolean forSale) {
        this.forSale = forSale;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setFormerOwners(String[] formerOwners) {
        this.formerOwners = formerOwners;
    }

    @Override
    public String toString() {
        return "Guitar{" + "strings=" + strings + ", forSale=" + forSale + ", model=" + model + ", brand='" + brand + '\'' + ", formerOwners=" + Arrays.toString(formerOwners) + '}';
    }
}
