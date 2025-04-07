package graph;

import java.util.Objects;

public record Vertice(String label) {

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Vertice(String objLabel)) {
            return Objects.equals(objLabel, label);
        }
        return false;
    }
}
