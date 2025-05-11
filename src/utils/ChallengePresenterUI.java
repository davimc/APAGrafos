package utils;


import graph.Vertice;
import representation.IncidenceMatrix;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class ChallengePresenterUI extends JFrame {
    private JTextField vertice1Field;
    private JTextField vertice2Field;
    private JTextArea resultadoArea;
    private IncidenceMatrix im;

    public ChallengePresenterUI(IncidenceMatrix im) {
        setTitle("Interface de Grafo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        this.im = im;

        // Painel de entrada
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Entrada de Vértices"));

        vertice1Field = new JTextField();
        vertice2Field = new JTextField();

        inputPanel.add(new JLabel("Vértice 1:"));
        inputPanel.add(vertice1Field);
        inputPanel.add(new JLabel("Vértice 2 (opcional):"));
        inputPanel.add(vertice2Field);

        add(inputPanel, BorderLayout.NORTH);

        // Painel de botões
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Operações"));

        JButton btnConectado = new JButton("É Conectado?");
        JButton btnSaoVizinhos = new JButton("São Vizinhos?");
        JButton btnVizinhos = new JButton("Vizinhos do Vértice");
        JButton btnGrau = new JButton("Grau do Vértice");

        buttonPanel.add(btnConectado);
        buttonPanel.add(btnSaoVizinhos);
        buttonPanel.add(btnVizinhos);
        buttonPanel.add(btnGrau);

        add(buttonPanel, BorderLayout.CENTER);

        // Área de resultado
        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        resultadoArea.setBorder(BorderFactory.createTitledBorder("Resultado"));
        add(new JScrollPane(resultadoArea), BorderLayout.SOUTH);

        // Ações dos botões
        btnConectado.addActionListener(e -> {
            String isConnected = im.isConnected();
            resultadoArea.setText("Grafo é conectado? " + isConnected);
        });

        btnSaoVizinhos.addActionListener(e -> {
            try {
                Vertice v1 = im.getVertice(vertice1Field.getText().trim());
                Vertice v2 = im.getVertice(vertice2Field.getText().trim());
                if (v1 != null && v2 != null) {
                    boolean vizinhos = im.isAdjacent(v1, v2);
                    ;
                    resultadoArea.setText("Vértices " + v1 + " e " + v2 + " são vizinhos? " + (vizinhos ? "Sim" : "Não"));
                } else {
                    resultadoArea.setText("Informe os dois vértices.");
                }
            } catch (IllegalArgumentException error) {
                resultadoArea.setText(error.getMessage());
            }
        });

        btnVizinhos.addActionListener(e -> {
            Vertice v = im.getVertice(vertice1Field.getText().trim());
            if (v != null) {
                List<Vertice> neighbors = im.findNeighbors(v);
                resultadoArea.setText("Vizinhos de " + v + ": " + neighbors);
            } else {
                resultadoArea.setText("Informe o vértice.");
            }
        });

        btnGrau.addActionListener(e -> {
            Vertice v = im.getVertice(vertice1Field.getText().trim());
            if (v != null) {
                String degree = im.calculateVertexDegree(v);
                resultadoArea.setText("Grau de " + v + ": " + degree);
            } else {
                resultadoArea.setText("Informe o vértice.");
            }
        });
    }

    // --- Substitua estes métodos pelos seus ---
}