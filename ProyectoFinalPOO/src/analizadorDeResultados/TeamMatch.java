package analizadorDeResultados;

public class TeamMatch {

    private String date;
    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;
    private String tournament;
    private String city;
    private String country;
    private boolean neutral;

    public TeamMatch(
            String date, String homeTeam, String awayTeam,
            int homeScore, int awayScore,
            String tournament, String city, String country, boolean neutral) {

        this.date = date;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.tournament = tournament;
        this.city = city;
        this.country = country;
        this.neutral = neutral;
    }

    @Override
    public String toString() {
        return date + " - " + homeTeam + " " + homeScore + " : " + awayScore + " " + awayTeam +
                " | " + tournament + " | " + city + ", " + country + " | Neutral: " + neutral;
    }
}
