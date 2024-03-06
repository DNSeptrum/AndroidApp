package com.example.javaandriod;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.List;

public class CategoryPhotosActivity extends AppCompatActivity {

    private ViewPager2 categoryViewPager;
    private Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_photos);

        // Znajdź ViewPager2 z XML-a
        categoryViewPager = findViewById(R.id.categoryViewPager);

        // Odczytaj informację o wybranej kategorii
        String selectedCategory = getIntent().getStringExtra("category");

        // Przykładowe identyfikatory zasobów zdjęć i ich nazwy
        int[] allPhotoResIds = ResourceHelper.getAllPhotoResIds();
        String[] allPhotoNames = ResourceHelper.getAllPhotoNames();
        String[] allPhotoCategory = ResourceHelper.getAllCategory();


        List<Integer> filteredPhotoResIds = new ArrayList<>();
        List<String> filteredPhotoNames = new ArrayList<>();
        for (int i = 0; i < allPhotoCategory.length; i++) {
            if (allPhotoCategory[i].startsWith(selectedCategory)) {
                filteredPhotoResIds.add(allPhotoResIds[i]);
                filteredPhotoNames.add(allPhotoNames[i]);
            }
        }

// Konwertuj listę Integer na tablicę int
        int[] photoResIdsArray = new int[filteredPhotoResIds.size()];
        for (int i = 0; i < filteredPhotoResIds.size(); i++) {
            photoResIdsArray[i] = filteredPhotoResIds.get(i);
        }

// Utwórz adapter dla ViewPager2
        PhotoPagerAdapter photoPagerAdapter = new PhotoPagerAdapter(this,
                photoResIdsArray,
                filteredPhotoNames.toArray(new String[0]));

        // Ustaw adapter na ViewPager2
        categoryViewPager.setAdapter(photoPagerAdapter);

        backButton = findViewById(R.id.backButtonwys);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Zamknij aktualną aktywność i wróć do poprzedniej aktywności
                finish();
            }
        });


    }
}