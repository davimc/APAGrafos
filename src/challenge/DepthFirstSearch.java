package challenge;

import graph.Vertice;
import representation.IncidenceMatrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DepthFirstSearch {
    private static final byte NOT_VISITED = (byte) 0;
    private static final byte NOT_CONNECTED = (byte) 0;
    private static final byte CONNECTED = (byte) 1;
    private static final byte WEAKLY_CONNECTED = (byte) -1;

    public static List<Byte> connectedDFSearch(IncidenceMatrix matrix) {
        Vertice first = matrix.getFirstVertice();
        List<Byte> visited = new ArrayList<>(Collections.nCopies(matrix.order(), NOT_VISITED));
        dsf(0, first, matrix,visited);

        return visited;
    }

    private static void dsf(int currentVerticeIndex, Vertice currentVertice,IncidenceMatrix matrix, List<Byte> visited) {

        int qttEdges = matrix.size();
        List<Vertice> vertices = matrix.getVertices();

        for(int j = 0; j < qttEdges; j++) {
            //if (matrix.getEdges(currentVertice).get(j) == (byte) 1) {
            if (matrix.getEdges(currentVertice).get(j) != NOT_VISITED) {
                visited.set(currentVerticeIndex, payVisit(matrix.getEdges(currentVertice).get(j), visited.get(currentVerticeIndex)));
                for (int i = 0; i < vertices.size(); i++) {
                    Vertice v = vertices.get(i);
                    if(v != currentVertice && !matrix.getEdges(v).get(j).equals(NOT_CONNECTED) && visited.get(i) == NOT_VISITED) {
                        dsf(i, vertices.get(i), matrix, visited);
                    }
                }
            }
        }
    }

    public static List<Vertice> DFSearchNeighbors(Vertice v, IncidenceMatrix m) {
        List<Vertice> neighbors = new ArrayList<>();
        for (int i = 0; i < m.getEdges(v).size(); i++) {
            byte b = m.getEdges(v).get(i);
            if(b == CONNECTED)
                for (Vertice neighbor: m.getVertices()) {
                    if (neighbor != v && !m.getEdges(neighbor).get(i).equals(NOT_CONNECTED))
                        neighbors.add(neighbor);
                }
        }
        return neighbors;
    }

    private static Byte payVisit(byte value, byte current) {
        return current != 1 ? value : CONNECTED;
    }

    private Integer[] getStartAndEndIndex(List<Byte> firstVertice) {
        Integer [] entries = new Integer[2];
        int start = 0, end = firstVertice.size() - 1;
        for (Byte aByte : firstVertice) {
            if (aByte == ((byte) 0)) break;
            start++;
        }
        entries[0] = start;
        for (int i = end; i >= start; i--) {
            if(firstVertice.get(i) == (byte) 0) break;
            end --;
        };
        entries[1] = end;
        return entries;
    }
}
