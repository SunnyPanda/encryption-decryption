package encryptdecrypt;

public class AlgorithmFactory {

    public static Algorithm create(String type) {
        switch (type) {
            case "shift":
                return new ShiftAlgorithm();
            case "unicode":
                return new UnicodeAlgorithm();
            default:
                return null;
        }
    }
}
