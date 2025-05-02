package utils;

import representation.IncidenceMatrix;
import representation.enums.RepresentationEnum;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GraphBuilderByFile {

    private String path;

    public GraphBuilderByFile(String path) {
        this.path = path;
    }

    public IncidenceMatrix buildGraph() {
        return readFile();
    }

    private IncidenceMatrix readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String linha = br.readLine();
            IncidenceMatrix im = instantiateDirection(linha);
            while(!(linha = br.readLine()).isEmpty())
                im.addVertice(linha);

            return im;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Arquvio não localizado");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> readFileList() {
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            List<String> graphInfos = new ArrayList<>();
            String linha;
            while(!(linha = br.readLine()).isEmpty())
                graphInfos.add(linha);

            return graphInfos;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Arquvio não localizado");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public IncidenceMatrix instantiateDirection(String firstString) {
        return RepresentationEnum.toEnum(firstString);
    }
}
