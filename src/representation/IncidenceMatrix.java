package representation;

import graph.Vertice;

import java.util.List;
import java.util.Set;


public interface  IncidenceMatrix{

    int size(); // qtt edges
    int order(); //qtt vertices
    Vertice getVertice(String label);
    List<Vertice> getVertices();
    boolean isDirected();
    String isConnected();
    boolean isAdjacent(Vertice v, Vertice n);
    String visitAllEdges(Set<Vertice> visited);
    List<Vertice> findNeighbors(Vertice v);
    String calculateVertexDegree(Vertice v);
    List<Byte> getEdges(Vertice vertice);
    Vertice getFirstVertice();
    void addVertice(String content);

}
