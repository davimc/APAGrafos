package structure;


import graph.Vertice;

import java.util.*;

public abstract class IncidenceMatrixImpl implements IncidenceMatrix {
    //tenho que fazer minha implementação de map
    private Map<Vertice, List<Byte>> matrix;

    public IncidenceMatrixImpl() {
        matrix = new HashMap<>();
    }

//mudar esse nome, pois fica ambiguo
    // todo estou contanod com a possibilidade dele já ser cadastrado, tenho que ver quando ele ainda for add
    protected void addVertice(String input, byte b1, byte b2) {
        try {
            String[] labels = transformInput(input);
            //aqui eu garanto que o vertice comece a existir
            checkVertice(labels);

            matrix.keySet().forEach((v) -> {
                if (v.label().equals(labels[0]) || v.label().equals(labels[1]))
                    matrix.get(v).set(matrix.size()-1, (v.label().equals(labels[0]) ? b1 : b2));

                else
                    matrix.get(v).add((byte) 0);


            });
        }catch (IllegalArgumentException e) {
            e.getMessage();
        }
    }


    private String[] transformInput(String input) throws IllegalArgumentException {
        String[] labels = input.split(",");
        if(labels.length < 2)
            throw new IllegalArgumentException(input + "está no formato incorreto");
        return labels;
    }

    //transformar para addVertice
    private void checkVertice(String[] labels) {
        List<Vertice> l = matrix.keySet().stream()
                .filter(v -> v.label().equals(labels[0]) || v.label().equals(labels[1])).toList();
        if(l.size() == 0) {
            matrix.put(new Vertice(labels[0]), List.of((byte) 1));
            matrix.put(new Vertice(labels[1]), List.of((byte) 1));
            return;
        }
        if(l.size() != 2)
            matrix.put( new Vertice(l.getFirst().label()
                    .equals(labels[0])? labels[1] : labels[0]), new ArrayList<>(Collections.nCopies(matrix.size(), (byte) 0)));
    }
}
