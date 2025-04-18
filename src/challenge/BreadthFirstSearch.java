package challenge;

import graph.Vertice;
import representation.IncidenceMatrix;

import java.util.List;

public class BreadthFirstSearch {


    public int isConnected(IncidenceMatrix matrix) {
        Integer graphSize =  matrix.size();
        Vertice firstVertice = matrix.getFirstVertice();
        //passa a primeira lista de arestas porque não é enecessário tratar ela
        List<Byte> firstListEdges = matrix.getEdges(firstVertice);
        Vertice initialVertice = matrix.getNext(firstVertice);
        Integer[] entrys = getStartAndEndIndex(firstListEdges);
        //já ignora todas as iniciais e finais com 1
        //ou seja, em uma lista de arestas que seja [1,1,1,0,0,1,1] o inicial será 3 e o final será 4
        int start = entrys[0], end = entrys[1];


        //tem dois edge, pois o primeiro não é necessário ser passado
        breadthFirstSearch(firstListEdges.get(0), graphSize, initialVertice, firstListEdges, matrix);

        return 0;
    }

    private int breadthFirstSearch(int start, int end, Vertice actualVertice, List<Byte> listOfConnections,IncidenceMatrix matrix) {
        //todo está funcionando apenas para grafos não direcionados
        if(start == end && listOfConnections.get(start) == (byte) 1) return 1;
        if (matrix.getNext(actualVertice) == null) return 0;
        List<Byte> edges = matrix.getEdges(actualVertice);

        for(int i = start; i <= end; i++) {
            if (edges.get(i) == (byte) 1) {
                listOfConnections.add(i, edges.get(i));
                if(i == start) start++;
                if(i == end) end--;
            }
        }
        else
            breadthFirstSearch(start, end, edges, matrix.)
        return false;
    }

    private Integer[] getStartAndEndIndex(List<Byte> firstVertice) {
        Integer [] entrys = new Integer[2];
        int start = 0, end = firstVertice.size() - 1;
        for (Byte aByte : firstVertice) {
            if (aByte == ((byte) 0)) break;
            start++;
        }
        entrys[0] = start;
        for (int i = end; i >= start; i--) {
            if(firstVertice.get(i) == (byte) 0) break;
            end --;
        };
        entrys[1] = end;
        return entrys;
    }
}
