package encryptdecrypt;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, String> arguments = new HashMap<>();

    public static void main(String[] args) {
        fillArgsMap(args);

        String mode = arguments.getOrDefault("-mode", "enc");

        EncoderDecoder processor = createProcessorFactory(mode);
        processor.encodeDecode(arguments);
//        String key = arguments.getOrDefault("-key", "0");
//        String inputString = readInputString();
//        String outputFilePath = arguments.getOrDefault("-out", "");

//        if (mode == null || key == null || outputFilePath == null) {
//            System.out.println("Error occurred! Argument doesn't have a value!");
//        } else {
//            String result = processInput(mode, inputString, Integer.parseInt(key));
//            outputResult(result, outputFilePath);
//        }

//        System.out.println('Z' + 1 - 1);
//        char letter = 'd';
//        System.out.println(letter + 1 - 1);
//        char a = 'a';
//        System.out.println(letter - a);
//        int key = 4;
//        int minus = letter - a - key;
//        System.out.println(minus);
//        int remainder = minus % 26;
//        System.out.println(remainder);
//        int plusZ = remainder + 'z';
//        System.out.println(plusZ);
//        System.out.println((char) (plusZ + 1));
//        System.out.println((char) ((('q' - 'a' - 4) % 26) + 'a'));
//        System.out.println(new ShiftAlgorithm().encrypt("Welcome to hyperskill!", 5));

    }

    static void fillArgsMap(String[] args) {
        for (int i = 0; i < args.length - 1; i += 2) {
            if (args[i + 1].startsWith("-")) {
                arguments.put(args[i], null);
                i--;
            } else {
                arguments.put(args[i], args[i + 1]);
            }
        }
    }

    static EncoderDecoder createProcessorFactory(String mode) {
        switch (mode) {
            case "enc":
                return new Encoder();
            case "dec":
                return new Decoder();
            default:
                return null;
        }
    }
//    static String readInputString() {
//        String inputString = "";
//        if (arguments.containsKey("-data")) {
//            inputString = arguments.get("-data");
//        } else if (arguments.containsKey("-in")) {
//            File inputFile = new File(arguments.get("-in"));
//            try (Scanner scanner = new Scanner(inputFile)) {
//                inputString = scanner.nextLine();
//            } catch (FileNotFoundException | NullPointerException e) {
//                System.out.println("Error occurred while reading input file!");
//            }
//        }
//        return inputString;
//    }
//
//    static String processInput(String mode, String inputString, int key) {
//        String result = "";
//        switch (mode) {
//            case "enc":
//                result = encrypt(inputString, key);
//                break;
//            case "dec":
//                result = decrypt(inputString, key);
//        }
//        return result;
//    }
//
//    static String encrypt(String original, int key) {
//        StringBuilder encrypted = new StringBuilder();
//        for (char letter : original.toCharArray()) {
//            encrypted.append((char)(letter + key));
//        }
//
//        return encrypted.toString();
//    }
//
//    static String decrypt(String encrypted, int key) {
//        StringBuilder original = new StringBuilder();
//        for (char letter : encrypted.toCharArray()) {
//            original.append((char)(letter - key));
//        }
//
//        return original.toString();
//    }
//
//    static void outputResult(String result, String outputFilePath) {
//        if (outputFilePath.isEmpty()) {
//            System.out.println(result);
//        } else {
//            File outputFile = new File(outputFilePath);
//            try (PrintWriter printWriter = new PrintWriter(outputFile)) {
//                printWriter.println(result);
//            } catch (FileNotFoundException e) {
//                System.out.println("Error occurred while trying to reach output file!");
//            }
//        }
//    }
}
