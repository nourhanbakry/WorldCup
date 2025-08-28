package com.example.worldcup.data.domain;

public record MatchModelRecord(String year, String stadium, String city, String homeTeamName,
                               String awayTeamName, String homeTeamGoals, String awayTeamGoals) {
}
