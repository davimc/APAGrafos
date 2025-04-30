package representation;


import challenge.ConnectedComponents;
import graph.Vertice;

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
        System.out.println(isConnected);
        List list = isConnected.stream().filter(a -> a != (byte) 1).toList();
        System.out.println(list);
        return list;

    }

    @Override
    public Vertice getFirstVertice() {
        return matrix.keySet().stream().findFirst().orElseThrow(()-> new IllegalArgumentException("The matrix is empty"));
    }
    @Override
    public List<Vertice> getVertices() {
        return matrix.keySet().stream().toList();
    }

    @Override
    public List<Byte> getEdges(Vertice vertice) {
        return matrix.get(vertice);
    }

    protected void verticeEdgeEntry(String input, byte b2) {
        try {
            String[] labels = transformInput(input);
            //aqui eu garanto que o vertice comece a existir
            checkVertice(labels);

            matrix.keySet().forEach((v) -> {
                if (v.label().equals(labels[0]) || v.label().equals(labels[1]))
                    //todo problema com dupla adição
                    matrix.get(v).add( (v.label().equals(labels[0]) ? (byte) 1 : b2));

                else
                    matrix.get(v).add((byte) 0);


            });
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Vertice getNext(Vertice actual) {
        boolean flag = false;

        for(Vertice v : matrix.keySet()) {
            if (flag)
                return v;
            if (v.equals(actual))
                flag = true;
        }
        return null;
    }

    private String[] transformInput(String input) throws IllegalArgumentException {
        String[] labels = input.split(",");
        if(labels.length < 2)
            throw new IllegalArgumentException(input + "está no formato incorreto");
        return labels;
    }

    //transformar para addVertice
    private void checkVertice(String[] labels) {
        List<Vertice> verticeList = matrix.keySet().stream()
                .filter(v -> v.label().equals(labels[0]) || v.label().equals(labels[1])).toList();
        if(verticeList.isEmpty()) {
            //se for vazio, não entre, caso contrário, imite o tamanho dos que já existem
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
        sb.append("IncidenceMatrixImpl{");
        matrix.forEach((v, l)-> {
            sb.append("\n" + v.label() + l + "\t " + l.size());
        });
        sb.append("\n}");
        return  sb.toString();
    }

}
