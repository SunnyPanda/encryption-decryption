package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

public abstract class EncoderDecoder {

    protected String outputFilePath;
    protected String key;
    protected String alg;

    public void encodeDecode(Map<String, String> arguments) {
        extractArguments(arguments);

        String inputString = readInputString(arguments);

        Algorithm algorithm = AlgorithmFactory.create(alg);
        String result = process(inputString, algorithm);

        outputResult(result);
    }

    abstract String process(String inputString, Algorithm algorithm);

    protected void extractArguments(Map<String, String> arguments) {
        key = arguments.getOrDefault("-key", "0");
        outputFilePath = arguments.getOrDefault("-out", "");
        alg = arguments.getOrDefault("-alg", "shift");
    }

    protected String readInputString(Map<String, String> arguments) {
        String inputString = "";
        if (arguments.containsKey("-data")) {
            inputString = arguments.get("-data");
        } else if (arguments.containsKey("-in")) {
            File inputFile = new File(arguments.get("-in"));
            try (Scanner scanner = new Scanner(inputFile)) {
                inputString = scanner.nextLine();
            } catch (FileNotFoundException | NullPointerException e) {
                System.out.println("Error occurred while reading input file!");
            }
        }
        return inputString;
    }

    protected void outputResult(String result) {
        if (outputFilePath.isEmpty()) {
            System.out.println(result);
        } else {
            File outputFile = new File(outputFilePath);
            try (PrintWriter printWriter = new PrintWriter(outputFile)) {
                printWriter.println(result);
            } catch (FileNotFoundException e) {
                System.out.println("Error occurred while trying to reach output file!");
            }
        }
    }
}
