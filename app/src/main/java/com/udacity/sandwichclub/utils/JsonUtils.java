package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private static final String SANDWICH_NAME = "name";
    private static final String SANDWICH_MAIN_NAME = "mainName";
    private static final String SANDWICH_OTHER_NAMES = "alsoKnownAs";
    private static final String SANDWICH_PLACE_OF_ORIGIN = "placeOfOrigin";
    private static final String SANDWICH_DESCRIPTION = "description";
    private static final String SANDWICH_IMAGE = "image";
    private static final String SANDWICH_INGREDIENTS = "ingredients";

    private static Sandwich makeSandwichFrom(String json) throws JSONException {

        JSONObject sandwichJSONObject = new JSONObject(json);

        JSONObject sandwichNameJSONObject = sandwichJSONObject.getJSONObject(SANDWICH_NAME);
        String mainName = sandwichNameJSONObject.getString(SANDWICH_MAIN_NAME);
        JSONArray alsoKnownAsJSONArray = sandwichNameJSONObject.getJSONArray(SANDWICH_OTHER_NAMES);
        List<String> alsoKnownAs = new ArrayList<>();
        for (int i = 0; i < alsoKnownAsJSONArray.length(); i++) {
            alsoKnownAs.add(alsoKnownAsJSONArray.getString(i));
        }

        String placeOfOrigin = sandwichJSONObject.getString(SANDWICH_PLACE_OF_ORIGIN);
        String description = sandwichJSONObject.getString(SANDWICH_DESCRIPTION);
        String image = sandwichJSONObject.getString(SANDWICH_IMAGE);

        JSONArray ingredientsJSONArray = sandwichJSONObject.getJSONArray(SANDWICH_INGREDIENTS);
        List<String> ingredients = new ArrayList<>();
        for (int i = 0; i < ingredientsJSONArray.length(); i++) {
            ingredients.add(ingredientsJSONArray.getString(i));
        }

        return new Sandwich(
                mainName,
                alsoKnownAs,
                placeOfOrigin,
                description,
                image,
                ingredients);
    }

    public static Sandwich parseSandwichJson(String json) throws JSONException {
        return makeSandwichFrom(json);
    }
}