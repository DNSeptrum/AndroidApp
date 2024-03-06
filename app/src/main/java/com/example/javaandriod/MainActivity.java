package com.example.javaandriod;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.snackbar.Snackbar;

//public class MainActivity extends AppCompatActivity {
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        TextView helloTextView = findViewById(R.id.helloTextView);
//        helloTextView.setText("Hello World from Java!");
//
//        Button exitButton = findViewById(R.id.exitButton);
//        exitButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Wywołaj metodę zamknięcia aplikacji
//                finish();
//            }
//        });
//        Button albumButton = findViewById(R.id.albumButton);
//        albumButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Otwórz nową aktywność (AlbumActivity)
//                Intent intent = new Intent(MainActivity.this, AlbumActivity.class);
//                startActivity(intent);
//            }
//        });
//    }
//}
public class MainActivity extends AppCompatActivity {


     @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.menu_item) {
            Toast.makeText(this, "Menu clicked", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.menu_album) {
            startActivity(new Intent(this, AlbumActivity.class));
            return true;
        } else if (itemId == R.id.menu_categories) {
            startActivity(new Intent(this, CategoriesActivity.class));
            return true;
        } else if (itemId == R.id.menu_add) {
            // Rozpocznij aktywność Dodaj
            // Dodaj odpowiednią aktywność
            return true;
        } else if (itemId == R.id.menu_edit) {
            // Rozpocznij aktywność Edytuj
            // Dodaj odpowiednią aktywność
            return true;
        } else if (itemId == R.id.menu_settings) {
            // Rozpocznij aktywność Ustawienia
            // Dodaj odpowiednią aktywność
            return true;
        } else if (itemId == R.id.menu_exit) {
            // Zamknij aplikację
            finish();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        TextView helloTextView = findViewById(R.id.helloTextView);
        helloTextView.setText("Javowy Album");



        Button albumButton = findViewById(R.id.albumButton);
        albumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Otwórz nową aktywność (AlbumActivity)
                Intent intent = new Intent(MainActivity.this, AlbumActivity.class);
                startActivity(intent);
            }
        });
        Button CategoryButton = findViewById(R.id.CategoryButton);
        CategoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Otwórz nową aktywność (AlbumActivity)
                Intent intent = new Intent(MainActivity.this, CategoriesActivity.class);
                startActivity(intent);
            }
        });
        Button AddButton = findViewById(R.id.AddButton);
        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Otwórz nową aktywność (AlbumActivity)
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });
        Button EditButton = findViewById(R.id.EditButton);
        EditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Otwórz nową aktywność (AlbumActivity)
                Intent intent = new Intent(MainActivity.this, EditActivity.class);
                startActivity(intent);
            }
        });
        Button SettingButton = findViewById(R.id.SettingButton);
        SettingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Otwórz nową aktywność (AlbumActivity)
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
        Button exitButton = findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Wywołaj metodę zamknięcia aplikacji
                finish();
            }
        });

    }

}