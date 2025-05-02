package utils;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.SingleGraph;
import representation.IncidenceMatrix;
import representation.enums.RepresentationEnum;

import java.util.List;


public class GraphVisualizerUI {
    public void buildUIGraph(List<String> infos) {
        System.setProperty("org.graphstream.ui", "swing");

        Graph graph = new SingleGraph("Meu Grafo");

        graph.setAttribute("ui.stylesheet", "node { text-alignment: above; text-size: 20px; }");

        assembleGraph(graph, infos);

        graph.display();
    }

    private void assembleGraph(Graph graph, List<String> infos) {
        IncidenceMatrix m = RepresentationEnum.toEnum(infos.remove(0));
        boolean isDirected = m.isDirected();
        infos.forEach(info -> {
            String[] inputs = InputBuilder.transformInput(info);
            for (String input : (inputs)) {
                if (graph.getNode(input) == null) {
                    graph.addNode(input).setAttribute("ui.label", input);
                }
            }

            graph.addEdge(inputs[0] + inputs[1], inputs[0], inputs[1], isDirected);
        });

    }
}
