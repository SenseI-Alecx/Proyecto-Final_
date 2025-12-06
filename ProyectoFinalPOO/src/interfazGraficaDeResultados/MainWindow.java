package interfazGraficaDeResultados;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class MainWindow extends JFrame {

    public MainWindow() {
        setTitle("Analizador de Resultados");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Consultas", new TabInformacion());
        tabs.addTab("Estadísticas", new TabEstadisticas());

        add(tabs);
    }

    public static void main(String[] args) {
        new MainWindow().setVisible(true);
    }
}
