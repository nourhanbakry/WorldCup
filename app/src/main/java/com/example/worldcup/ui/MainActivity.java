package com.example.worldcup.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.worldcup.databinding.ActivityMainBinding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        try {
            openFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void openFile() throws IOException {
        // to open it from assets and the return will be inputStream
        InputStream inputStream = getAssets().open("worldcup.csv");
        // inputStream reader to read it and buffered reader wrap it to more effient operations
        BufferedReader readFile    =  new BufferedReader(new InputStreamReader(inputStream));
        List<String> getLines = readFile.lines().collect(Collectors.toList());
        for (int i = 0;i<getLines.size(); i++){
            Log.d("MAIN_ACTIVITY", getLines.get(i));
        }

    }

}