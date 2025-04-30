package representation.enums;

import representation.IncidenceMatrix;
import representation.IncidenceMatrixDirected;
import representation.IncidenceMatrixUndirected;

public enum RepresentationEnum {

    UnD("ND", new IncidenceMatrixUndirected()), D("D",new IncidenceMatrixDirected());

    private final String cod;
    private final IncidenceMatrix representation;

    RepresentationEnum(String cod, IncidenceMatrix representation) {
        this.cod = cod;
        this.representation = representation;
    }

    public String getCod() {
        return cod;
    }

    public IncidenceMatrix getRepresentation() {
        return representation;
    }

    public static IncidenceMatrix toEnum(String cod) {
        if(cod == null) return null;

        for(RepresentationEnum r: RepresentationEnum.values())
            if(r.getCod().equals(cod))
                 return r.getRepresentation();
        throw new IllegalArgumentException(cod + "does not exists");
    }
}
