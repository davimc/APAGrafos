package representation.enums;

public enum TypeConnection {

    NOT_CONNECTED((byte) 0, "Não conexo"), WEAKLY_CONNECTED((byte) -1, "Fracamente conexo"), CONNECTED((byte) 1, "Conexo");

    private final Byte cod;
    private final String desc;

    TypeConnection(Byte cod, String desc) {
        this.cod = cod;
        this.desc = desc;
    }

    public Byte getCod() {
        return cod;
    }

    public String getDesc() {
        return desc;
    }

    public static String toEnum(Byte cod) {
        if(cod == null) return null;

        for(TypeConnection c: TypeConnection.values())
            if(c.getCod().equals(cod))
                return c.getDesc();
        throw new IllegalArgumentException(cod + "does not exists");
    }
}
