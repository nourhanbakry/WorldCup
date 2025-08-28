package com.example.worldcup.data;

import com.example.worldcup.data.domain.MatchModelRecord;

import java.util.ArrayList;

public class DataManager {
    private static DataManager dataManagerInstance;
    ArrayList<MatchModelRecord> listOfMatches = new ArrayList<>();
    private int matchIndex = 0;

    private DataManager() {
    }

    public static DataManager getDataManagerInstance() {
        if (dataManagerInstance == null) {
            dataManagerInstance = new DataManager();
        }
        return dataManagerInstance;
    }

    public void addMatchToMatchesList(MatchModelRecord match) {
        listOfMatches.add(match);
    }

    public MatchModelRecord getCurrentMatch() {
        return listOfMatches.get(matchIndex);

    }

    public MatchModelRecord getNextMatch() {
        matchIndex++;
        if (matchIndex == listOfMatches.size() - 1) {
            matchIndex = 0;
        }
        return listOfMatches.get(matchIndex);
    }

    public MatchModelRecord getPreviousMatch() {
        matchIndex--;
        if (matchIndex == -1) {
            matchIndex = listOfMatches.size() - 1;
        }
        return listOfMatches.get(matchIndex);

    }
}
