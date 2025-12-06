package interfazGraficaDeResultados;

import javax.swing.*;
import java.awt.*;

import analizadorDeResultados.TeamInfoService;
import logicaDeResultados.TeamInfoFormatter;

public class TabInformacion extends JPanel {

    public TabInformacion() {
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
            TeamInfoService service = new TeamInfoService("results.csv");
            String team = input.getText().trim();

            String result = TeamInfoFormatter.format(service.getAllMatches(team));
            output.setText(result);
        });
    }
}