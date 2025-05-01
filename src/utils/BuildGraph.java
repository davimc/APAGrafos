package utils;

import representation.IncidenceMatrix;
import representation.enums.RepresentationEnum;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildGraph {

    private String path;
    private Map<String, List<String>> grafo = new HashMap<>();
    private boolean isDirected;

    public BuildGraph(String path) {
        this.path = path;
        this.grafo = new HashMap<>();
    }

    public boolean isDirected() {
        return isDirected;
    }

    public String read(IncidenceMatrix matrix) {
        return null;
    }

    public IncidenceMatrix instantiate() {
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String linha = br.readLine();
            if(linha != null)
                return RepresentationEnum.toEnum(linha);;
          throw new IllegalArgumentException("Arquivo vazio");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
