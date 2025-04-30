import representation.IncidenceMatrix;
import representation.enums.RepresentationEnum;

public class Main {
    public static void main(String[] args) {

        IncidenceMatrix imd = RepresentationEnum.toEnum("D");
        IncidenceMatrix imu = RepresentationEnum.toEnum("ND");;

        imu.addVertice("A,B");
        imu.addVertice("A,D");
        imu.addVertice("B,D");
        imu.addVertice("G,F");
        imu.addVertice("F,A");
//TODO transformar array visited em list de bytes
        //se houver 0, ele é não conectado
        // senão e houver -1 ele é fracamente conectado
        // senão ele é conectado
        // TODO 2  a resposta de conectado colocar na matriz de incidência, para cada tipo tratar a sua resposta

        System.out.println(imu.isConnected());

        /* //teste com 15 entradas
        im.addVertice("E,H", (byte)1,(byte)1);
        im.addVertice("F,G", (byte)1,(byte)1);
        im.addVertice("G,B", (byte)1,(byte)1);
        im.addVertice("K,B", (byte)1,(byte)1);
        im.addVertice("A,Y", (byte)1,(byte)1);
        im.addVertice("B,Y", (byte)1,(byte)1);
        im.addVertice("C,Y", (byte)1,(byte)1);
        im.addVertice("D,Y", (byte)1,(byte)1);
        im.addVertice("E,Y", (byte)1,(byte)1);
        im.addVertice("F,Y", (byte)1,(byte)1);
        im.addVertice("Z,N", (byte)1,(byte)1);*/
        /*//teste com 58 entradas
        im.addVertice("A,B", (byte)1, (byte)1);
        im.addVertice("B,C", (byte)1, (byte)1);
        im.addVertice("C,D", (byte)1, (byte)1);
        im.addVertice("D,A", (byte)1, (byte)1);
        im.addVertice("A,E", (byte)1, (byte)1);
        im.addVertice("E,F", (byte)1, (byte)1);
        im.addVertice("F,G", (byte)1, (byte)1);
        im.addVertice("G,H", (byte)1, (byte)1);
        im.addVertice("H,E", (byte)1, (byte)1);
        im.addVertice("I,J", (byte)1, (byte)1);
        im.addVertice("J,K", (byte)1, (byte)1);
        im.addVertice("K,L", (byte)1, (byte)1);
        im.addVertice("L,I", (byte)1, (byte)1);
        im.addVertice("M,N", (byte)1, (byte)1);
        im.addVertice("N,O", (byte)1, (byte)1);
        im.addVertice("O,P", (byte)1, (byte)1);
        im.addVertice("P,Q", (byte)1, (byte)1);
        im.addVertice("Q,R", (byte)1, (byte)1);
        im.addVertice("S,T", (byte)1, (byte)1);
        im.addVertice("T,U", (byte)1, (byte)1);
        im.addVertice("U,V", (byte)1, (byte)1);
        im.addVertice("V,W", (byte)1, (byte)1);
        im.addVertice("W,X", (byte)1, (byte)1);
        im.addVertice("X,Y", (byte)1, (byte)1);
        im.addVertice("Y,Z", (byte)1, (byte)1);
        im.addVertice("Z,S", (byte)1, (byte)1);
        im.addVertice("A,K", (byte)1, (byte)1);
        im.addVertice("B,L", (byte)1, (byte)1);
        im.addVertice("C,M", (byte)1, (byte)1);
        im.addVertice("D,N", (byte)1, (byte)1);
        im.addVertice("E,O", (byte)1, (byte)1);
        im.addVertice("F,P", (byte)1, (byte)1);
        im.addVertice("G,Q", (byte)1, (byte)1);
        im.addVertice("H,R", (byte)1, (byte)1);
        im.addVertice("I,S", (byte)1, (byte)1);
        im.addVertice("J,T", (byte)1, (byte)1);
        im.addVertice("K,U", (byte)1, (byte)1);
        im.addVertice("L,V", (byte)1, (byte)1);
        im.addVertice("M,W", (byte)1, (byte)1);
        im.addVertice("N,X", (byte)1, (byte)1);
        im.addVertice("O,Y", (byte)1, (byte)1);
        im.addVertice("P,Z", (byte)1, (byte)1);
        im.addVertice("Q,A", (byte)1, (byte)1);
        im.addVertice("R,B", (byte)1, (byte)1);
        im.addVertice("S,C", (byte)1, (byte)1);
        im.addVertice("T,D", (byte)1, (byte)1);
        im.addVertice("U,E", (byte)1, (byte)1);
        im.addVertice("V,F", (byte)1, (byte)1);
        im.addVertice("W,G", (byte)1, (byte)1);
        im.addVertice("X,H", (byte)1, (byte)1);
        im.addVertice("Y,I", (byte)1, (byte)1);
        im.addVertice("Z,J", (byte)1, (byte)1);
        im.addVertice("K,M", (byte)1, (byte)1);
        im.addVertice("L,N", (byte)1, (byte)1);
        im.addVertice("M,O", (byte)1, (byte)1);
        im.addVertice("N,P", (byte)1, (byte)1);
        im.addVertice("O,Q", (byte)1, (byte)1);
        im.addVertice("P,R", (byte)1, (byte)1);*/

/*        System.out.println(imu);
        System.out.println(imd);*/

    }
}