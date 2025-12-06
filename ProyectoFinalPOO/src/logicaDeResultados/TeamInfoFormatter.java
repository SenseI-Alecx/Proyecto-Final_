package logicaDeResultados;


import analizadorDeResultados.TeamMatch;
import java.util.List;

public class TeamInfoFormatter {

    public static String format(List<TeamMatch> matches) {
        if (matches.isEmpty()) {
            return "No existen registros para este equipo.";
        }

        StringBuilder sb = new StringBuilder();
        for (TeamMatch match : matches) {
            sb.append(match.toString()).append("\n");
        }
        return sb.toString();
    }
}