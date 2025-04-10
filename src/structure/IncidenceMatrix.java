package structure;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;


import graph.Vertice;

//transformar em interface
// Para nao direcionados usar BitSet 0, 1
//Para direcionados usar List<byte> -1, 0, 1
public interface  IncidenceMatrix{
    //todo voltar para receber apenas content no parametro
    void addVertice(String content);
}
