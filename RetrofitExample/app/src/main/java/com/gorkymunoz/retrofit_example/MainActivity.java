package com.gorkymunoz.retrofit_example;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gorkymunoz.retrofit_example.adapters.CharacterAdapter;
import com.gorkymunoz.retrofit_example.network.models.character.Character;
import com.gorkymunoz.retrofit_example.viewmodel.RickMortyViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();

    RickMortyViewModel rickAndMortyViewModel;
    CharacterAdapter characterAdapter;
    RecyclerView rvCharacters;
    List<Character> characterList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvCharacters = findViewById(R.id.rv_characters);
        rickAndMortyViewModel = new ViewModelProvider(this).get(RickMortyViewModel.class);
        rickAndMortyViewModel.fetchCharacters();
        rickAndMortyViewModel.getCharacterResponseMutableLiveData().observe(this, characterResponse -> {
            List<Character> charactersUpdated = characterResponse.getCharacters();
            characterList.clear();
            characterList.addAll(charactersUpdated);
            characterAdapter.notifyDataSetChanged();
        });

        initializeRV();
    }

    void initializeRV() {
        if (characterAdapter == null) {
            characterAdapter = new CharacterAdapter(this, characterList);
            rvCharacters.setLayoutManager(new GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false));
            rvCharacters.setAdapter(characterAdapter);
            rvCharacters.setItemAnimator(new DefaultItemAnimator());
        } else {
            characterAdapter.notifyDataSetChanged();
        }
    }
}