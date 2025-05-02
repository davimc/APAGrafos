package representation;

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
}
