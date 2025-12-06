package interfazGraficaDeResultados;

import javax.swing.*;
import java.awt.*;

import analizadorDeResultados.StatisticsService;
import analizadorDeResultados.Stats;

public class TabEstadisticas extends JPanel {

    public TabEstadisticas() {
        setLayout(new BorderLayout());

        JPanel top = new JPanel();
        JTextField input = new JTextField(20);
        JButton search = new JButton("Buscar");
        top.add(new JLabel("Equipo: "));
        top.add(input);
        top.add(search);

        JTextArea output = new JTextArea();
        output.setEditable(false);
        JScrollPane scroll = new JScrollPane(output);

        add(top, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        search.addActionListener(e -> {
            StatisticsService service = new StatisticsService("results.csv");
            String team = input.getText().trim();

            Stats stats = service.getStatsForTeam(team);

            output.setText(
                "Victorias: " + stats.getWins() +
                "\nDerrotas: " + stats.getLosses() +
                "\nEmpates: " + stats.getDraws() +
                "\nGoles a favor: " + stats.getGoalsFor()
            );
        });
    }
}
