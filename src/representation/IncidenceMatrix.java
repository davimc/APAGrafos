package representation;

import graph.Vertice;

import java.util.List;
import java.util.Set;

//transformar em interface
// Para nao direcionados usar BitSet 0, 1
//Para direcionados usar List<byte> -1, 0, 1
public interface  IncidenceMatrix{

    int size(); // qtt edges
    int order(); //qtt vertices
    List<Vertice> getVertices();

    List<Byte> getEdges(Vertice vertice);
    Vertice getFirstVertice();
    void addVertice(String content);
    Vertice getNext(Vertice current);

}
