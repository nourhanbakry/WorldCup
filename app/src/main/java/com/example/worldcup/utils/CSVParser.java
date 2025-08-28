package com.example.worldcup.utils;

import com.example.worldcup.data.domain.MatchModelRecord;

public class CSVParser {
    public static MatchModelRecord csvParser(String line) {
        String[] tokens = line.split(",");
        DataIndexsSingleTon dataIndexsSingleTon = DataIndexsSingleTon.getDataIndexsSingleTonInstance();
        String year = tokens[dataIndexsSingleTon.getYearIndex()];
        String stadium = tokens[dataIndexsSingleTon.getStadiumIndex()];
        String city = tokens[dataIndexsSingleTon.getCityIndex()];
        String homeTeam = tokens[dataIndexsSingleTon.getHomeTeamNameIndex()];
        String awayTeam = tokens[dataIndexsSingleTon.getAwayTeamNameIndex()];
        String homeTeamGoals = tokens[dataIndexsSingleTon.getHomeTeamGoalsIndex()];
        String awayTeamGoals = tokens[dataIndexsSingleTon.getAwayTeamGoalsIndex()];

        return new MatchModelRecord(year, stadium, city, homeTeam, awayTeam, homeTeamGoals, awayTeamGoals);
    }
}
