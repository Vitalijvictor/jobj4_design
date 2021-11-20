package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Mainguitar {
    public static void main(String[] args) {
        final Guitar guitar = new Guitar(6, true, new Model("Warlock"), "Raptor",
                new String[] {"John Cena", "Eddy Lee", "Jim Carrey"});

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(guitar));

        final String guitarJson =
                "{"
                        + "\"strings\":6,"
                        + "\"forSale\":true,"
                        + "\"model\":"
                        + "{"
                        + "\"model\":\"Warlock\""
                        + "},"
                        + "\"brand\":\"Raptor\","
                        + "\"formerOwners\":"
                        + "[\"John Cena\", \"Eddy Lee\", \"Jim Carrey\"]"
                        + "}";
        final Guitar guitarMod = gson.fromJson(guitarJson, Guitar.class);
        System.out.println(guitarMod);
    }
}

