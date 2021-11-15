package ru.job4j.serialization.json;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Person person = new Person(false, 30,
                new Contact("11-111"), new String[]{"Worker", "Married"});

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(person + "   Converting the person "
                + "object to a json string"));

        final String personJson = "{" + "\"sex\":false," + "\"age\":35,"
                + "\"contact\":" + "{" + "\"phone\":\"+7(924)111-111-11-11\""
                + "}," + "\"statuses\":" + "[\"Student\",\"Free\"]" + "}";
        final Person personMod = gson.fromJson(personJson, Person.class);
        System.out.println(System.lineSeparator());
        System.out.println(personMod + "   Modifying the json string");

        System.out.println(System.lineSeparator());
        final Gson jsonBackToString = new GsonBuilder().create();
        System.out.println(jsonBackToString.toJson(personMod
                + "   -  back to" + " json"));
    }
}