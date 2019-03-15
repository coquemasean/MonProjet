package com.vogella.android.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RecipeApi {

    @GET("recettes.json")
    Call<List<Recipe>> getListRecipes();
}
