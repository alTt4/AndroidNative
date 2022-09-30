package edu.fbansept.dfsr_presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AnimalsList extends AppCompatActivity {
    private ArrayList<Animal> animalList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals_list);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                "https://zoo-animal-api.herokuapp.com/animals/rand/4",
                response -> {
                    animalList = new ArrayList<>();

                    for(int i = 0; i < response.length(); i++ ) {
                        try {
                            JSONObject json = response.getJSONObject(i);
                            Animal animal = new Animal(json);
                            animalList.add(animal);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    RecyclerView rvAnimalList = findViewById(R.id.rvAnimalList);
                    rvAnimalList.setLayoutManager(new LinearLayoutManager(this));
                    rvAnimalList.setAdapter(new AnimalListAdapter(animalList));

                },
                error -> Log.d("volley",error.toString())
        );

        RequestManager.getInstance(this).addToRequestQueue(jsonArrayRequest);
    }
}