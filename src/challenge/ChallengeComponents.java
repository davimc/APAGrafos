package challenge;

import graph.Vertice;
import representation.IncidenceMatrix;

import java.util.List;
import java.util.Set;

public interface ChallengeComponents {

    static List<Byte> isConnected(IncidenceMatrix matrix) {
        return DepthFirstSearch.connectedDFSearch(matrix);
    }

    static String visitAllEdges(IncidenceMatrix im, Set<Vertice> visited) {
        return DepthFirstSearch.dFSearchVisitAllEdges(im, visited);
    }


}
