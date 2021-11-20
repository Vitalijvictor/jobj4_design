package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

@XmlRootElement(name = "dog")
@XmlAccessorType(XmlAccessType.FIELD)
public class Dog {

    @XmlAttribute
    private String sex;

    @XmlAttribute
    private boolean evil;
    private int age;
    private Temper temper;
    private String[] pets;


    public Dog() {
    }

    public Dog(String sex, boolean evil, int age, Temper temper, String[] pets) {
        this.sex = sex;
        this.evil = evil;
        this.age = age;
        this.temper = temper;
        this.pets = pets;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public boolean isEvil() {
        return evil;
    }

    public void setEvil(boolean evil) {
        this.evil = evil;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Temper getTemper() {
        return temper;
    }

    public void setTemper(Temper temper) {
        this.temper = temper;
    }

    public String[] getPets() {
        return pets;
    }

    public void setPets(String[] pets) {
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "Dog{" + "sex='" + sex + '\'' + ", evil=" + evil + ", age=" + age + ", temper=" + temper + ", pets=" + Arrays.toString(pets) + '}';
    }
}

