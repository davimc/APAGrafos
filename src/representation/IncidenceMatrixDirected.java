package representation;

public class IncidenceMatrixDirected extends IncidenceMatrixImpl {
    @Override
    public void addVertice(String content) {
        this.verticeEdgeEntry(content, (byte) -1);
    }
}
