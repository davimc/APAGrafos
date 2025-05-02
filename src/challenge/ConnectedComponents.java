package challenge;

import representation.IncidenceMatrix;

import java.util.List;

public interface ConnectedComponents {

    static List<Byte> isConnected(IncidenceMatrix matrix) {
        return DepthFirstSearch.connectedDFSearch(matrix);
    }
}
