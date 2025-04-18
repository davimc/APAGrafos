package challenge;

import graph.Vertice;
import representation.IncidenceMatrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ConnectedComponentsImpl implements ConnectedComponents {
    //private IncidenceMatrix graph;

    protected List<Vertice> visitPaths(IncidenceMatrix matrix) {
        List<Byte> edges = new ArrayList<>(Collections.nCopies(matrix.size(), (byte) 0));


        return null;
    }


}
