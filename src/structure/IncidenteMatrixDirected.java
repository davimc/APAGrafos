package structure;

public class IncidenteMatrixDirected extends IncidenceMatrixImpl {
    @Override
    public void addVertice(String content) {
        this.addVertice(content, (byte) 1, (byte) -1);
    }
}
