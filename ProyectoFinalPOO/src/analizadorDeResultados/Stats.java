package analizadorDeResultados;

public class Stats {

    private int wins;
    private int losses;
    private int draws;
    private int goalsFor;

    public Stats(int wins, int losses, int draws, int goalsFor) {
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.goalsFor = goalsFor;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getDraws() {
        return draws;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    @Override
    public String toString() {
        return "Victorias: " + wins +
               "\nDerrotas: " + losses +
               "\nEmpates: " + draws +
               "\nGoles a favor: " + goalsFor;
    }
}
