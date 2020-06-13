package encryptdecrypt;

public class UnicodeAlgorithm implements Algorithm{
    @Override
    public String encrypt(String original, int key) {
        StringBuilder encrypted = new StringBuilder();
        for (char letter : original.toCharArray()) {
            encrypted.append((char)(letter + key));
        }

        return encrypted.toString();
    }

    @Override
    public String decrypt(String encrypted, int key) {
        StringBuilder original = new StringBuilder();
        for (char letter : encrypted.toCharArray()) {
            original.append((char)(letter - key));
        }

        return original.toString();
    }
}
