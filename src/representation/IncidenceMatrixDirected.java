package representation;

import graph.Vertice;
import representation.enums.TypeConnection;

import java.util.List;

public class IncidenceMatrixDirected extends IncidenceMatrixImpl {
    @Override
    public void addVertice(String content) {
        this.verticeEdgeEntry(content, (byte) -1);
    }

    private final byte CONNECTED = (byte) 1;
    private final byte NOT_CONNECTED = (byte) 0;
    private final byte WEAKLEY_CONNECTED = (byte) -1;
    @Override
    public String isConnected() {
       List<Byte> b = checkConnection();
       byte c = CONNECTED;
       if(!b.isEmpty())
           c = b.stream().anyMatch(x -> x == WEAKLEY_CONNECTED) ? WEAKLEY_CONNECTED : NOT_CONNECTED;
       return TypeConnection.toEnum(c);
    }

    @Override
    public boolean isDirected() {
        return true;
    }

    @Override
    public String calculateVertexDegree(Vertice v) {
        List<Byte> edges =  super.listVertexDegree(v);
        int exit = edges.stream().filter(e -> e == (byte) 1).toList().size();
        return "Grau de saída = " + exit + "\nGrau de entrada = " + (edges.size() - exit);
    }
}
