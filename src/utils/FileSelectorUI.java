package utils;

import javax.swing.*;

public class FileSelectorUI {

    public static String selecionarArquivo() {
        JFileChooser chooser = new JFileChooser();
        int resultado = chooser.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile().getName();
        } else {
            System.out.println("Nenhum arquivo selecionado.");
            return null;
        }
    }
}
