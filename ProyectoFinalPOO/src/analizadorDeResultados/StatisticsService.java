package analizadorDeResultados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StatisticsService {

    private String filePath;

    public StatisticsService(String filePath) {
        this.filePath = filePath;
    }

    public Stats getStatsForTeam(String team) {

        int wins = 0;
        int losses = 0;
        int draws = 0;
        int goalsFor = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {

                String[] columns = line.split(",");

                if (columns.length < 5) continue;

                String homeTeam = columns[1].trim();
                String awayTeam = columns[2].trim();
                int homeScore = Integer.parseInt(columns[3].trim());
                int awayScore = Integer.parseInt(columns[4].trim());

                boolean isHome = homeTeam.equalsIgnoreCase(team);
                boolean isAway = awayTeam.equalsIgnoreCase(team);

                if (!isHome && !isAway) {
                    continue; 
                }

                if (isHome) {
                    goalsFor += homeScore;

                    if (homeScore > awayScore) wins++;
                    else if (homeScore < awayScore) losses++;
                    else draws++;
                }

                if (isAway) {
                    goalsFor += awayScore;

                    if (awayScore > homeScore) wins++;
                    else if (awayScore < homeScore) losses++;
                    else draws++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Stats(wins, losses, draws, goalsFor);
    }
}

