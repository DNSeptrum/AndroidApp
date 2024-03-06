package com.example.javaandriod;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class AlbumActivity extends AppCompatActivity {

    private ViewPager2 photoViewPager;
    private Button backButton;

    private Button categoriesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_activity);

        TextView albumTextView = findViewById(R.id.albumTextView);
        albumTextView.setText("Album");

        // Znajdź ViewPager2 i przycisk "Powrót" z XML-a
        photoViewPager = findViewById(R.id.imageView);
        backButton = findViewById(R.id.backButton);


        // Przykładowe identyfikatory zasobów zdjęć (zastąp je odpowiednimi zasobami)
        int[] photoResIds = ResourceHelper.getAllPhotoResIds();
        String[] photoNames = ResourceHelper.getAllPhotoNames();
        // Utwórz adapter dla ViewPager2

        PhotoPagerAdapter photoPagerAdapter = new PhotoPagerAdapter(this, photoResIds, photoNames);


        photoViewPager.setAdapter(photoPagerAdapter);
        // Ustaw adapter na ViewPager2


        // Dodaj obsługę kliknięcia przycisku "Powrót"
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Zamknij aktualną aktywność i wróć do poprzedniej aktywności
                finish();
            }
        });

    }
}

