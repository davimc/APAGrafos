package structure;


import graph.Vertice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class IncidenceMatrixImpl implements IncidenceMatrix {
    //tenho que fazer minha implementação de map
    private Map<Vertice, List<Byte>> matrix;

    public IncidenceMatrixImpl() {
        matrix = new HashMap<>();
    }

//mudar esse nome, pois fica ambiguo
    // todo estou contanod com a possibilidade dele já ser cadastrado, tenho que ver quando ele ainda for add
    protected void addVertice(String input, byte b1, byte b2) {
        String[] labels = input.split(",");
        matrix.keySet().forEach((v) -> {
            if (v.label().equals(labels[0]) || v.label().equals(labels[1]))
                matrix.get(v).add(v.label().equals(labels[0]) ? b1 : b2);

            else
                matrix.get(v).add((byte) 0);


        });
    }
}
