package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String jsonString) {
        Sandwich sandwich = new Sandwich();
        try {
            JSONObject sandwichJson = new JSONObject(jsonString);
            JSONObject name = sandwichJson.getJSONObject("name");
            JSONArray akaJson =  name.getJSONArray("alsoKnownAs");
            JSONArray ingredients =  sandwichJson.getJSONArray("ingredients");
            List<String> akaList = new ArrayList<>();
            List<String> ingredientsList = new ArrayList<>();

            for(int i = 0; i < akaJson.length(); i++){
                akaList.add(akaJson.getString(i));
            }
            sandwich.setAlsoKnownAs( akaList );
            sandwich.setDescription(sandwichJson.getString("description"));
            sandwich.setImage(sandwichJson.getString("image"));
            for(int i = 0; i < ingredients.length(); i++){
                ingredientsList.add(ingredients.getString(i));
            }
            sandwich.setIngredients( ingredientsList );
            sandwich.setMainName(name.getString("mainName"));
            sandwich.setPlaceOfOrigin(sandwichJson.getString("placeOfOrigin"));
            return sandwich;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
