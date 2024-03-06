package com.example.javaandriod;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

//public class EditActivity extends AppCompatActivity {
//
//    private Spinner photoSpinner;
//    private EditText newPhotoNameEditText;
//    private Spinner newCategorySpinner;
//    private Button editButton;
//
//    private Button backButton;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_edit);
//
//        // Znajdź widoki z XML-a
//        photoSpinner = findViewById(R.id.photoSpinner);
//        newPhotoNameEditText = findViewById(R.id.newPhotoNameEditText);
//        newCategorySpinner = findViewById(R.id.newCategorySpinner);
//        editButton = findViewById(R.id.editButton);
//
//        // Ustaw opcje wyboru dla Spinnera ze zdjęciami
//        ArrayAdapter<String> photoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ResourceHelper.getAllPhotoNames());
//        photoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        photoSpinner.setAdapter(photoAdapter);
//
//        // Ustaw opcje wyboru dla nowej kategorii
//        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ResourceHelper.categories);
//        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        newCategorySpinner.setAdapter(categoryAdapter);
//
//        // Ustawienie słuchacza na zmianę wybranego zdjęcia
//        photoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
//                // Wyświetl obecne informacje o zdjęciu
//                String selectedPhotoName = photoSpinner.getSelectedItem().toString();
//                int selectedPhotoIndex = ResourceHelper.getPhotoIndex(selectedPhotoName);
//
//                // Ustaw obecne informacje w EditText i Spinnerze
//                newPhotoNameEditText.setText(ResourceHelper.getAllPhotoNames()[selectedPhotoIndex]);
//
//                String category = ResourceHelper.getAllCategory()[selectedPhotoIndex];
//                int categoryIndex = getCategoryIndex(category);
//                newCategorySpinner.setSelection(categoryIndex);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parentView) {
//                // Tu możesz dodać dodatkowe obsługi, jeśli potrzebujesz
//            }
//        });
//
//        // Dodaj obsługę kliknięcia przycisku "Edytuj"
//        editButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Pobierz dane od użytkownika
//                String selectedPhotoName = photoSpinner.getSelectedItem().toString();
//                String newPhotoName = newPhotoNameEditText.getText().toString();
//                String newCategory = newCategorySpinner.getSelectedItem().toString();
//
//                // Edytuj nazwę i kategorię istniejącego zdjęcia
//                ResourceHelper.editPhotoInfo(selectedPhotoName, newPhotoName, newCategory);
//
//                // Poinformuj użytkownika o edycji
//                Toast.makeText(EditActivity.this, "Edytowano informacje o zdjęciu", Toast.LENGTH_SHORT).show();
//
//                // Zakończ aktywność
//                finish();
//            }
//        });
//
//        backButton = findViewById(R.id.backButton);
//        backButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Zamknij aktualną aktywność i wróć do poprzedniej aktywności
//                finish();
//            }
//        });
//
//    }
//
//    private int getCategoryIndex(String category) {
//        for (int i = 0; i < ResourceHelper.categories.length; i++) {
//            if (category.equals(ResourceHelper.categories[i])) {
//                return i;
//            }
//        }
//        return 0; // Domyślnie zwróć pierwszą kategorię, jeśli nie znajdziesz dopasowania
//    }
//
//
//}
public class EditActivity extends AppCompatActivity {

    private Spinner photoSpinner;
    private EditText newPhotoNameEditText;
    private Spinner newCategorySpinner;
    private Button editButton;

    private Button backButton;
    private ImageView selectedPhotoImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        // Znajdź widoki z XML-a
        photoSpinner = findViewById(R.id.photoSpinner);
        newPhotoNameEditText = findViewById(R.id.newPhotoNameEditText);
        newCategorySpinner = findViewById(R.id.newCategorySpinner);
        editButton = findViewById(R.id.editButton);
        selectedPhotoImageView = findViewById(R.id.selectedPhotoImageView);
        // Ustaw opcje wyboru dla Spinnera ze zdjęciami
        ArrayAdapter<String> photoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ResourceHelper.getAllPhotoNames());
        photoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        photoSpinner.setAdapter(photoAdapter);

        // Ustaw opcje wyboru dla nowej kategorii
        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ResourceHelper.categories);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        newCategorySpinner.setAdapter(categoryAdapter);

        // Ustawienie słuchacza na zmianę wybranego zdjęcia
        photoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Wyświetl obecne informacje o zdjęciu
                String selectedPhotoName = photoSpinner.getSelectedItem().toString();
                int selectedPhotoIndex = ResourceHelper.getPhotoIndex(selectedPhotoName);

                // Ustaw obecne informacje w EditText i Spinnerze
                newPhotoNameEditText.setText(ResourceHelper.getAllPhotoNames()[selectedPhotoIndex]);

                String category = ResourceHelper.getAllCategory()[selectedPhotoIndex];
                int categoryIndex = getCategoryIndex(category);
                newCategorySpinner.setSelection(categoryIndex);

                // Ustaw wybrane zdjęcie w ImageView
                int selectedPhotoResId = ResourceHelper.getAllPhotoResIds()[selectedPhotoIndex];
                selectedPhotoImageView.setImageResource(selectedPhotoResId);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

            // ...
        });

        // Dodaj obsługę kliknięcia przycisku "Edytuj"
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Pobierz dane od użytkownika
                String selectedPhotoName = photoSpinner.getSelectedItem().toString();
                String newPhotoName = newPhotoNameEditText.getText().toString();
                String newCategory = newCategorySpinner.getSelectedItem().toString();

                // Edytuj nazwę i kategorię istniejącego zdjęcia
                ResourceHelper.editPhotoInfo(selectedPhotoName, newPhotoName, newCategory);

                // Poinformuj użytkownika o edycji
                Toast.makeText(EditActivity.this, "Edytowano informacje o zdjęciu", Toast.LENGTH_SHORT).show();

                // Zakończ aktywność
                finish();
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

    private int getCategoryIndex(String category) {
        for (int i = 0; i < ResourceHelper.categories.length; i++) {
            if (category.equals(ResourceHelper.categories[i])) {
                return i;
            }
        }
        return 0; // Domyślnie zwróć pierwszą kategorię, jeśli nie znajdziesz dopasowania
    }


}