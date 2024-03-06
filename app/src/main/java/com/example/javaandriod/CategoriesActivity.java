package com.example.javaandriod;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
public class CategoriesActivity extends AppCompatActivity {
    private Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        // Lista dostępnych kategorii (możesz dostosować do swoich potrzeb)
        final String[] categories = {"Android", "Samochody", "Zwierzęta", "Różne"};

        // Ustawienie adaptera listy
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, categories);

        // Znajdź ListView w layoutcie
        ListView listView = findViewById(R.id.listViewCategories);

        // Ustawienie adaptera dla ListView
        listView.setAdapter(adapter);

        // Obsługa kliknięcia na kategorię

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedCategory = categories[position];
                Intent intent = new Intent(CategoriesActivity.this, CategoryPhotosActivity.class);
                intent.putExtra("category", selectedCategory);
                startActivity(intent);
            }
        });
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Zamknij aktualną aktywność i wróć do poprzedniej aktywności
                finish();
            }
        });
    }
}