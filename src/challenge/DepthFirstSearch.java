package challenge;

import graph.Vertice;
import representation.IncidenceMatrix;

import java.util.List;
import java.util.Objects;

public class DepthFirstSearch {

    public static void connectedDfSearch(IncidenceMatrix matrix) {
        Vertice first = matrix.getFirstVertice();
        boolean[] visited = new boolean[matrix.order()];

        dsf(0, first, matrix,visited);

        String isConnected = "Conexo";
        for(boolean v: visited) {
            System.out.println(v);
            if (!v)
                isConnected = "Não conexo";
        }

        System.out.println("O grafo " + matrix + " é um grafo: " + isConnected);
    }

    private static void dsf(int currentVerticeIndex, Vertice currentVertice,IncidenceMatrix matrix, boolean[] visited) {
        visited[currentVerticeIndex] = true;
        int qttEdges = matrix.size();
        List<Vertice> vertices = matrix.getVertices();

        for(int j = 0; j < qttEdges; j++) {
            if (matrix.getEdges(currentVertice).get(j) == (byte) 1) {
                for (int i = 0; i < vertices.size(); i++) {
                    Vertice v = vertices.get(i);
                    if(v != currentVertice && matrix.getEdges(v).get(j).equals((byte) 1) && !visited[i]) {

                        //System.out.println(currentVertice.label() + " " + matrix.getEdges(currentVertice) + " " + j + ", " + i + visited[i]);
                        dsf(i, vertices.get(i), matrix, visited);
                    }
                }
            }
        }

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
