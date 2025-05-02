package representation;

import graph.Vertice;

import java.util.List;

//transformar em interface
// Para nao direcionados usar BitSet 0, 1
//Para direcionados usar List<byte> -1, 0, 1
public interface  IncidenceMatrix{

    int size(); // qtt edges
    int order(); //qtt vertices
    Vertice getVertice(String label);
    List<Vertice> getVertices();
    boolean isDirected();
    String isConnected();
    List<Vertice> findNeighbors(Vertice v);
    int calculateVertexDegree(Vertice v);
    List<Byte> getEdges(Vertice vertice);
    Vertice getFirstVertice();
    void addVertice(String content);

}
