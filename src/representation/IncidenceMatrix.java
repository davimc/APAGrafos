package representation;

import graph.Vertice;

import java.util.List;

//transformar em interface
// Para nao direcionados usar BitSet 0, 1
//Para direcionados usar List<byte> -1, 0, 1
public interface  IncidenceMatrix{

    int size();
    List<Byte> getEdges(Vertice vertice);
    Vertice getFirstVertice();
    void addVertice(String content);
    Vertice getNext(Vertice current);

}
