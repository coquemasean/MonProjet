package com.vogella.android.myapplication;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://coquemasean.github.io/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RecipeApi recipeApi = retrofit.create(RecipeApi.class);

        Call<List<Recipe>> call = recipeApi.getListRecipes();
        call.enqueue(new Callback<List<Recipe>>() {
            @Override
            public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
                List<Recipe> recipeList = response.body();
                showList(recipeList);
            }

            @Override
            public void onFailure(Call<List<Recipe>> call, Throwable t) {

            }
        });

    }

    private void showList(List<Recipe> recipeList) {
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MyAdapter(recipeList, new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Recipe item) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                Gson gson = new Gson();
                String jsonItem = gson.toJson(item);
                intent.putExtra("KEY",jsonItem);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(mAdapter);

    }

}