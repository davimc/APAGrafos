import graph.Vertice;
import structure.IncidenceMatrix;
import structure.IncidenceMatrixImpl;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        IncidenceMatrix im = new IncidenceMatrixImpl();
        im.addVertice("A,B", (byte)1,(byte)1);
        im.addVertice("A,C", (byte)1,(byte)1);
        im.addVertice("B,D", (byte)1,(byte)1);
        im.addVertice("A,G", (byte)1,(byte)1);
        im.addVertice("C,F", (byte)1,(byte)1);//todo Vertice[label=F]=[1, 1]???
        im.addVertice("F,A", (byte)1,(byte)1);
        System.out.println(im);
    }
}