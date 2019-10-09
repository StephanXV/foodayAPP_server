package it.univaq.disim.mobile.fooday.utilities;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonParser {
    private List<String> cities = new ArrayList<>();

    public JsonParser() {
    }

    public static  List<String> parseCityAroundUser(String response){
        JSONObject jor = new JSONObject(response);
        JSONArray lista = jor.getJSONArray("list");

        List<String> cities = new ArrayList<>();

        for (int i = 0; i < lista.length(); i++) {
            JSONObject oggetto = lista.getJSONObject(i);
            String citta = oggetto.getString("name");
            if (!cities.contains(citta)) {
                cities.add(citta);
            }
        }

        for (int x = 0; x<cities.size()-1; x++){
            String n = (cities.get(x));
            if (n.charAt(1) == '\'') cities.remove(x+1);
        }

        return cities;
    }
}
