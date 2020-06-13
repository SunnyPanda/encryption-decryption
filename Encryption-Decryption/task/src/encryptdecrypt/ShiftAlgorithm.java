package encryptdecrypt;

public class ShiftAlgorithm implements Algorithm {
    @Override
    public String encrypt(String original, int key) {
        StringBuilder encrypted = new StringBuilder();

        for (char letter : original.toCharArray()) {
            if (Character.isAlphabetic(letter)) {
                if (letter >= 'a') {
                    encrypted.append(encryptLowerCase(letter, key));
                } else {
                    encrypted.append(encryptUpperCase(letter, key));
                }
            } else {
                encrypted.append(letter);
            }
        }

        return encrypted.toString();
    }

    @Override
    public String decrypt(String encrypted, int key) {
        StringBuilder original = new StringBuilder();
        for (char letter : encrypted.toCharArray()) {
            if (Character.isAlphabetic(letter)) {
                if (letter >= 'a') {
                    original.append(decryptLowerCase(letter, key));
                } else {
                    original.append(decryptUpperCase(letter, key));
                }
            } else {
                original.append(letter);
            }
        }

        return original.toString();
    }

    private char encryptLowerCase(char letter, int key) {
        return (char) (((letter - 'a' + key) % 26) + 'a');
    }

    private char encryptUpperCase(char letter, int key) {
        return (char) (((letter - 'A' + key) % 26) + 'A');
    }

    private char decryptLowerCase(char letter, int key) {
        return letter - key < 'a'
                ? (char) (((letter - 'a' - key) % 26) + 'z' + 1)
                : (char) (((letter - 'a' - key) % 26) + 'a');
    }

    private char decryptUpperCase(char letter, int key) {
        return letter - key < 'A'
                ? (char) (((letter - 'A' - key) % 26) + 'Z' + 1)
                : (char) (((letter - 'A' - key) % 26) + 'A');
    }
}
