package representation;


import challenge.ConnectedComponents;
import challenge.DepthFirstSearch;
import graph.Vertice;
import utils.InputBuilder;

import java.util.*;

public abstract class IncidenceMatrixImpl implements IncidenceMatrix {
    //tenho que fazer minha implementação de map
    private Map<Vertice, List<Byte>> matrix;
    private List<Byte> isConnected;

    public IncidenceMatrixImpl() {
        matrix = new LinkedHashMap<>();
        isConnected = new ArrayList<>();
    }

    protected List<Byte> checkConnection() {
        if (isConnected.size() != size())
            isConnected = ConnectedComponents.isConnected(this);
        List list = isConnected.stream().filter(a -> a != (byte) 1).toList();
        return list;

    }

    @Override
    public Vertice getFirstVertice() {
        return matrix.keySet().stream().findFirst().orElseThrow(()-> new IllegalArgumentException("The matrix is empty"));
    }

    @Override
    public Vertice getVertice(String label) {
        for (Vertice v: this.getVertices())
            if (v.label().equalsIgnoreCase(label)) {
                return v;
            }
        throw new IllegalArgumentException("Este vertice não está presente");
    }

    @Override
    public List<Vertice> getVertices() {
        return matrix.keySet().stream().toList();
    }

    @Override
    public List<Byte> getEdges(Vertice vertice) {
        return matrix.get(vertice);
    }

    @Override
    public List<Vertice> findNeighbors(Vertice v) {
        return DepthFirstSearch.findNeighbors(v, this);
    }

    @Override
    public int calculateVertexDegree(Vertice v) {
        return this.getEdges(v).stream().filter(e -> e != (byte) 0).toList().size();
    }

    protected void verticeEdgeEntry(String input, byte b2) {
        try {
            String[] labels = InputBuilder.transformInput(input);
            //aqui eu garanto que o vertice comece a existir
            checkVertice(labels);

            matrix.keySet().forEach((v) -> {
                if (v.label().equals(labels[0]) || v.label().equals(labels[1]))
                    matrix.get(v).add( (v.label().equals(labels[0]) ? (byte) 1 : b2));

                else
                    matrix.get(v).add((byte) 0);


            });
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void checkVertice(String[] labels) {
        List<Vertice> verticeList = matrix.keySet().stream()
                .filter(v -> v.label().equals(labels[0]) || v.label().equals(labels[1])).toList();
        if(verticeList.isEmpty()) {
            //se for vazio, não entre, caso contrário, imite o tamanho dos que já existem
            System.out.println("Adicionando vertices " + labels[0] + " e " + labels[1]);
            int size = matrix.values().stream().findFirst().orElse(new ArrayList<Byte>()).size();

            List<Byte> newList1 = new ArrayList<>(Collections.nCopies(size, (byte) 0));
            List<Byte> newList2 = new ArrayList<>(Collections.nCopies(size, (byte) 0));

            matrix.put(new Vertice(labels[0]), newList1);
            matrix.put(new Vertice(labels[1]), newList2);
            return;
        }

        if(verticeList.size() != 2) {
            Vertice v = verticeList.getFirst();
            String label = (v.label().equals(labels[0]) ? labels[1] : labels[0]);
            int size = ((matrix.get(v).size()));

            matrix.put(new Vertice(label),
                    new ArrayList<>(Collections.nCopies(size, (byte) 0)));
        }
    }


    @Override
    public int size() {
        return matrix.values().stream().findFirst()
                .orElseThrow(EmptyStackException::new).size();
    }

    @Override
    public int order() {
        return matrix.size();
    }

    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getSimpleName() );
        matrix.forEach((v, l)-> {
            sb.append("\n" + v.label() + l + "\t " + l.size());
        });
        sb.append("\n}");
        return  sb.toString();
    }

}
