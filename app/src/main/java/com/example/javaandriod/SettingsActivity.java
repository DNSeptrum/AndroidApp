package com.example.javaandriod;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class SettingsActivity extends AppCompatActivity {

    private SeekBar brightnessSeekBar;
    private Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);



        Switch darkModeSwitch = findViewById(R.id.darkModeSwitch);

        darkModeSwitch.setChecked(isDarkModeEnabled());

        // Obsłuż zmianę wartości przełącznika
        darkModeSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                setDarkMode();
            } else {
                setLightMode();
            }
        });

        brightnessSeekBar = findViewById(R.id.brightnessSeekBar);

        TextView Naglowek = findViewById(R.id.naglowek);
        TextView pasek = findViewById(R.id.pasek);

        // Pobierz aktualną jasność ekranu
        int currentBrightness = Settings.System.getInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, -1);

        // Ustaw aktualną jasność na pasku postępu
        brightnessSeekBar.setProgress(currentBrightness);

        // Ustaw słuchacza na zmianę jasności
        brightnessSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Ustaw nową jasność ekranu
                setBrightness(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Nic do zrobienia na początku śledzenia dotyku
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Nic do zrobienia po zakończeniu śledzenia dotyku
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

    private void setBrightness(int brightness) {
        // Ustaw nową jasność ekranu
        Settings.System.putInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, brightness);
    }

    private boolean isDarkModeEnabled() {
        // Tutaj możesz użyć preferencji użytkownika, SharedPreferences lub innego mechanizmu
        // aby sprawdzić, czy Tryb Ciemny jest włączony.
        // Wartość domyślna może być dostosowana do Twoich potrzeb.
        return false;
    }

    private void setDarkMode() {
        // Włącz Tryb Ciemny
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
    }

    private void setLightMode() {
        // Włącz Tryb Jasny
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }
}
//public class SettingsActivity extends AppCompatActivity {
//
//    private SeekBar brightnessSeekBar;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_settings);
//
//        brightnessSeekBar = findViewById(R.id.brightnessSeekBar);
//
//        brightnessSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                // Otwórz ekran ustawień jasności ekranu
//                openBrightnessSettings();
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//                // Nic do zrobienia na początku śledzenia dotyku
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//                // Nic do zrobienia po zakończeniu śledzenia dotyku
//            }
//        });
//    }
//
//    private void openBrightnessSettings() {
//        Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
//        intent.setData(Uri.parse("package:" + getPackageName()));
//        startActivity(intent);
//    }
//}