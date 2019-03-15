package com.vogella.android.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String jsonItem = getIntent().getStringExtra("KEY");
        Gson gson = new Gson();
        Recipe recipe = gson.fromJson(jsonItem, Recipe.class);
        recipe.name();
        recipe.description();
        recipe.getIngredients();

        TextView txtTitle = findViewById(R.id.title2);

    }
}
