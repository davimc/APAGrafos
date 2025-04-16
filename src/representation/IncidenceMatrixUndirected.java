package representation;

public class IncidenceMatrixUndirected extends IncidenceMatrixImpl {
    @Override
    public void addVertice(String content) {
        this.addVertice(content, (byte) 1);
    }
}
