package com.example.worldcup.utils;

public class DataIndexsSingleTon {
    private static DataIndexsSingleTon dataIndexsSingleTonInstance;
    private final int yearIndex;
    private final int stadiumIndex;
    private final int cityIndex;
    private final int homeTeamNameIndex;
    private final int awayTeamNameIndex;
    private final int homeTeamGoalsIndex;
    private final int awayTeamGoalsIndex;

    private DataIndexsSingleTon() {
        this.yearIndex = 0;
        this.stadiumIndex = 3;
        this.cityIndex = 4;
        this.homeTeamNameIndex = 5;
        this.awayTeamNameIndex = 8;
        this.homeTeamGoalsIndex = 6;
        this.awayTeamGoalsIndex = 7;
    }

    public static DataIndexsSingleTon getDataIndexsSingleTonInstance() {
        if (dataIndexsSingleTonInstance == null) {
            dataIndexsSingleTonInstance = new DataIndexsSingleTon();
        }
        return dataIndexsSingleTonInstance;
    }

    public int getYearIndex() {
        return yearIndex;
    }

    public int getStadiumIndex() {
        return stadiumIndex;
    }

    public int getCityIndex() {
        return cityIndex;
    }

    public int getHomeTeamNameIndex() {
        return homeTeamNameIndex;
    }

    public int getAwayTeamNameIndex() {
        return awayTeamNameIndex;
    }

    public int getHomeTeamGoalsIndex() {
        return homeTeamGoalsIndex;
    }

    public int getAwayTeamGoalsIndex() {
        return awayTeamGoalsIndex;
    }
}
