package analizadorDeResultados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TeamInfoService {

    private String filePath;

    public TeamInfoService(String filePath) {
        this.filePath = filePath;
    }

    public List<TeamMatch> getAllMatches(String team) {
        List<TeamMatch> matches = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] c = line.split(",");

                String date = c[0].trim();
                String home = c[1].trim();
                String away = c[2].trim();
                int hs = Integer.parseInt(c[3].trim());
                int as = Integer.parseInt(c[4].trim());
                String tournament = c[5].trim();
                String city = c[6].trim();
                String country = c[7].trim();
                boolean neutral = Boolean.parseBoolean(c[8].trim());

                if (home.equalsIgnoreCase(team) || away.equalsIgnoreCase(team)) {
                    matches.add(new TeamMatch(date, home, away, hs, as,
                                              tournament, city, country, neutral));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return matches;
    }
}