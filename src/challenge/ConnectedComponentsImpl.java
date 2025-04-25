package challenge;

import graph.Vertice;
import representation.IncidenceMatrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConnectedComponentsImpl implements ConnectedComponents {
    //private IncidenceMatrix graph;

    public void isConnected(IncidenceMatrix matrix) {

        DepthFirstSearch.connectedDfSearch(matrix);


        return;
    }
}
