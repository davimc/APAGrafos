import challenge.DepthFirstSearch;
import graph.Vertice;
import representation.IncidenceMatrix;
import utils.ChallengePresenterUI;
import utils.GraphBuilderByFile;
import utils.FileSelectorUI;
import utils.GraphVisualizerUI;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {


        GraphBuilderByFile bg = new GraphBuilderByFile(FileSelectorUI.selecionarArquivo());
        IncidenceMatrix im = bg.buildGraph();
        new GraphVisualizerUI().buildUIGraph(bg.readFileList());

        SwingUtilities.invokeLater(() -> {
            ChallengePresenterUI gui = new ChallengePresenterUI(im);
            gui.setVisible(true );
        });
    }
}