package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "temper")
public class Temper {

    @XmlAttribute
    private String temper;

    public Temper() {
    }

    public Temper(String temper) {
        this.temper = temper;
    }

    @Override
    public String toString() {
        return "Temper{" + "temper='" + temper + '\'' + '}';
    }
}