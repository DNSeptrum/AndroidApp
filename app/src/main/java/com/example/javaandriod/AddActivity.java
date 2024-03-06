package com.example.javaandriod;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {
    private Button backButton;
    private Button addButton;
    private EditText photoResIdEditText;
    private EditText photoNameEditText;
    private Spinner categorySpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        TextView helloTextView = findViewById(R.id.Dodaj);
      //  helloTextView.setText("Album from Java!");

        photoResIdEditText = findViewById(R.id.photoIDEditText);
        photoNameEditText = findViewById(R.id.photoNameEditText);
        categorySpinner = findViewById(R.id.categorySpinner);
        addButton = findViewById(R.id.AddButton2);

        // Ustaw opcje wyboru kategorii
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ResourceHelper.categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(adapter);

        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Zamknij aktualną aktywność i wróć do poprzedniej aktywności
                finish();
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Pobierz dane od użytkownika
                String photoName = photoNameEditText.getText().toString();
                String PhotoID = photoResIdEditText.getText().toString();
              //  int photoResId = Integer.parseInt(photoResIdEditText.getText().toString());
                String selectedCategory = (String) categorySpinner.getSelectedItem();
                int photoResId = getResources().getIdentifier(PhotoID.toLowerCase(), "drawable", getPackageName());
                // Dodaj nowe zdjęcie do zasobów
                ResourceHelper.addPhoto(photoResId, photoName, selectedCategory);

                // Zakończ aktywność
                finish();
            }
        });
    }
}
