
package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;

public class MainGuitar {
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

        JSONObject guitarObject = new JSONObject("{\"socks\":\"white\", "
                + "\"snickers\":\"nike\", \"jacket\":\"blue\"}");
        System.out.println(guitarObject);

        Guitar mainGuitar = new Guitar(4, true, new Model("Corwette"),
                "Warwick",
                new String[] {" Bootsy Collins", "Robert Trujillo", " Jonas Hellborg"});
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("strings", guitar.getStrings());
        jsonObject.put("forSale", guitar.isForSale());
        jsonObject.put("model", guitar.getModel());
        jsonObject.put("brand", guitar.getBrand());
        jsonObject.put("formerOwners", guitar.getFormerOwners());
        System.out.println(jsonObject.toString());
        System.out.println(new JSONObject(mainGuitar).toString());
    }
}

