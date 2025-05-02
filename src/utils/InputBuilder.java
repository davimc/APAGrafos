package utils;

public class InputBuilder {

    public static String[] transformInput(String input) throws IllegalArgumentException {
        String[] labels = input.split(",");
        if(labels.length < 2)
            throw new IllegalArgumentException(input + "está no formato incorreto");
        return labels;
    }
}
