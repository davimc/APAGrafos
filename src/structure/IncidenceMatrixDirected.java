package structure;

public class IncidenceMatrixDirected extends IncidenceMatrixImpl {
    @Override
    public void addVertice(String content) {
        this.addVertice(content, (byte) 1, (byte) -1);
    }
}
