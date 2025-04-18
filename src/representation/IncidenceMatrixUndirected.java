package representation;

public class IncidenceMatrixUndirected extends IncidenceMatrixImpl {
    @Override
    public void addVertice(String content) {
        this.verticeEdgeEntry(content, (byte) 1);
    }
}
