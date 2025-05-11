package representation;

import graph.Vertice;
import representation.enums.TypeConnection;

public class IncidenceMatrixUndirected extends IncidenceMatrixImpl {
    private final byte CONNECTED = (byte) 1;
    private final byte NOT_CONNECTED = (byte) 0;

    @Override
    public void addVertice(String content) {
        this.verticeEdgeEntry(content, (byte) 1);
    }

    @Override
    public String isConnected() {


        return TypeConnection.toEnum(checkConnection().isEmpty() ? CONNECTED : NOT_CONNECTED);

    }

    @Override
    public boolean isDirected() {
        return false;
    }

    @Override
    public String calculateVertexDegree(Vertice v) {
        int degree = super.listVertexDegree(v).size();
        return "Grau do Vertice " + v.label() + ": " + degree;
    }
}
