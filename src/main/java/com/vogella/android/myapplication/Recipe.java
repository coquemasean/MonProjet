package com.vogella.android.myapplication;

import java.util.List;

public class Recipe {
    String name;
    String description;
    List<String> ingredients;


    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public List<String> getIngredients() {
        return ingredients;
    }
}
