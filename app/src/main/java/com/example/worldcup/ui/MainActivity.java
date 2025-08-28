package com.example.worldcup.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.worldcup.data.DataManager;
import com.example.worldcup.data.domain.MatchModelRecord;
import com.example.worldcup.databinding.ActivityMainBinding;
import com.example.worldcup.utils.AppConstants;
import com.example.worldcup.utils.CSVParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    DataManager dataManagerInstance = DataManager.getDataManagerInstance();

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
        setupDataFile();
        addCallBacks();
    }

    private void addCallBacks() {
        binding.prevoius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MatchModelRecord match = dataManagerInstance.getPreviousMatch();
                bindMatch(match);

            }
        });
        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MatchModelRecord match = dataManagerInstance.getNextMatch();
                bindMatch(match);
            }
        });


    }

    private void bindMatch(MatchModelRecord match) {
        binding.year.setText(match.year());
        binding.stadium.setText(match.stadium());
        binding.homeTeam.setText(match.homeTeamName());
        binding.awayTeam.setText(match.awayTeamName());
        binding.homeTeamGoals.setText(match.homeTeamGoals());
        binding.awayTeamGoals.setText(match.awayTeamGoals());
    }

    private void setupDataFile() {
        try {
            List<String> lines = openFile();
            parseFile(lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    } //read and parse file

    private List<String> openFile() throws IOException {
        // to open it from assets and the return will be inputStream
        InputStream inputStream = getAssets().open(AppConstants.fileName);
        // inputStream reader to read it and buffered reader wrap it to more effient operations
        BufferedReader readFile = new BufferedReader(new InputStreamReader(inputStream));
        List<String> lines = readFile.lines().toList();
        return lines;

    }

    // the data come from its source first time we parse it and (DataManagerRoles) store it in a list then show it
    private void parseFile(List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            MatchModelRecord currentMatch = CSVParser.csvParser(lines.get(i));
            Log.d(AppConstants.mainActivityLogTag, currentMatch.toString());
            dataManagerInstance.addMatchToMatchesList(currentMatch);
        }
        bindMatch(dataManagerInstance.getCurrentMatch());
    }


}